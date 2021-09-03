package com.teste.micro.modules.pauta.service;

import com.teste.micro.exception.RecordNotFoundException;
import com.teste.micro.handler.BusinessException;
import com.teste.micro.helper.i18n.Translator;
import com.teste.micro.modules.enums.EnumSimNao;
import com.teste.micro.modules.pauta.dto.CreatePautaDto;
import com.teste.micro.modules.pauta.dto.IniciarPautaDto;
import com.teste.micro.modules.pauta.dto.PautaDto;
import com.teste.micro.modules.pauta.dto.ResultadoPautaDto;
import com.teste.micro.modules.pauta.entity.Pauta;
import com.teste.micro.modules.pauta.mapper.PautaMapper;
import com.teste.micro.modules.pauta.repository.PautaRepository;
import com.teste.micro.modules.pauta.service.fila.RabbitmqService;
import com.teste.micro.modules.scheduler.pautarunnable.PautaRuneable;
import com.teste.micro.modules.start.conections.Fila;
import com.teste.micro.modules.votacao.repository.VotoRepository;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class PautaServiceImpl implements PautaService {

  private final PautaRepository pautaRepository;
  private final PautaMapper pautaMapper;
  private final RabbitmqService rabbitmqService;
  private final VotoRepository votoRepository;
  private final Translator translator;

  private static final Integer MINUTO_FECHAMENTO_PAUTA_PADRAO = 1;

  @Override
  public PautaDto create(CreatePautaDto createPautaDto) {
    var pauta = pautaMapper.createPautaDtoToPauta(createPautaDto);
    return pautaMapper.pautaToPautaDto(pautaRepository.save(pauta));
  }

  @Override
  public void iniciarPauta(Integer idPauta, IniciarPautaDto iniciarPautaDto) {
    var pauta = pautaRepository.findById(idPauta).orElseThrow();
    this.fillDadosPauta(pauta, iniciarPautaDto);
    pautaRepository.save(pauta);
    this.agendaEncerramento(idPauta, pauta.getDtFechamento());
  }

  private void fillDadosPauta(Pauta pauta, IniciarPautaDto iniciarPautaDto) {
    pauta.setDtFechamento(DateUtils.addMinutes(new Date(), MINUTO_FECHAMENTO_PAUTA_PADRAO));

    if (Objects.nonNull(iniciarPautaDto.getDtFechamento())) {
      pauta.setDtFechamento(iniciarPautaDto.getDtFechamento());
    }

    pauta.setFlEmVotacao(EnumSimNao.S.name());
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public void finalizarPauta(Integer idPauta) {
    var pauta = pautaRepository.findById(idPauta).orElseThrow();
    pauta.setVotos(votoRepository.findByIdPauta(idPauta));
    pauta.setFlEmVotacao(EnumSimNao.N.name());

    var resultadoDto = buildResultadoPauta(pauta);
    rabbitmqService.enviarMensagem(Fila.RESULTADO_VOTACAO.name(), resultadoDto);

    pautaRepository.save(pauta);
  }

  private ResultadoPautaDto buildResultadoPauta(Pauta pauta) {

    Integer resultadoSim =
        pauta.getVotos().stream()
            .filter(voto -> EnumSimNao.S.name().equals(voto.getVoto()))
            .collect(Collectors.toList())
            .size();
    Integer resultadoNao =
        pauta.getVotos().stream()
            .filter(voto -> EnumSimNao.N.name().equals(voto.getVoto()))
            .collect(Collectors.toList())
            .size();

    return ResultadoPautaDto.builder()
        .idPauta(pauta.getId())
        .nmPauta(pauta.getNome())
        .dePauta(pauta.getDescricao())
        .resultadoSim(resultadoSim)
        .resultadoNao(resultadoNao)
        .build();
  }

  @Override
  public Pauta findById(Integer idPauta) {
    var pauta = pautaRepository.findById(idPauta).orElseThrow(RecordNotFoundException::new);
    return pauta;
  }

  @Override
  public void isAptaParaVotacao(Integer idPauta) {
    var pauta = this.findById(idPauta);

    if (!pauta.isEmVotacao()) {
      throw new BusinessException(translator.get("validation.pauta.nao.esta.votacao"));
    }

    if (Objects.isNull(pauta.getDtFechamento())) {
      throw new BusinessException(translator.get("validation.nao.existe.data.de.fechamento"));
    }

    if (pauta.getDtFechamento().before(new Date())) {
      throw new BusinessException(translator.get("validation.a.pauta.foi.finalizada"));
    }
  }

  @Override
  public void agendarTarefasDeFinalizacoes() {
    var pautas = pautaRepository.findByflEmVotacao(EnumSimNao.S.name());

    if (CollectionUtils.isEmpty(pautas)) {
      return;
    }

    pautas.stream()
        .filter(pauta -> Objects.nonNull(pauta.getDtFechamento()))
        .collect(Collectors.toList())
        .forEach(
            pauta -> {
              agendaEncerramento(pauta.getId(), pauta.getDtFechamento());
            });
  }

  private void agendaEncerramento(Integer idPauta, Date dtFechamento) {
    ConcurrentTaskScheduler tarefa = new ConcurrentTaskScheduler();
    tarefa.schedule(new PautaRuneable(idPauta, this), dtFechamento);
  }
}
