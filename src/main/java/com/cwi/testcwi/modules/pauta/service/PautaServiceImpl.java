package com.cwi.testcwi.modules.pauta.service;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.IniciarPautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;
import com.cwi.testcwi.modules.pauta.entity.Pauta;
import com.cwi.testcwi.modules.pauta.mapper.PautaMapper;
import com.cwi.testcwi.modules.pauta.repository.PautaRepository;
import com.cwi.testcwi.modules.scheduler.PautaRunnable.PautaRuneable;
import java.util.Date;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class PautaServiceImpl implements PautaService {

  private final PautaRepository pautaRepository;
  private final PautaMapper pautaMapper;

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
    this.agendarEncerramento(idPauta, pauta.getDtFechamento());
  }

  private void fillDadosPauta(Pauta pauta, IniciarPautaDto iniciarPautaDto) {
    pauta.setDtFechamento(DateUtils.addMinutes(new Date(), MINUTO_FECHAMENTO_PAUTA_PADRAO));

    if (Objects.nonNull(iniciarPautaDto.getDtFechamento())) {
      pauta.setDtFechamento(iniciarPautaDto.getDtFechamento());
    }

    pauta.setFlEmVotacao("S");
  }

  @Override
  public void finalizarPauta(Integer idPauta) {
    var pauta = pautaRepository.findById(idPauta).orElseThrow();
    pauta.setFlEmVotacao("N");
    pautaRepository.save(pauta);
  }

  private void agendarEncerramento(Integer idPauta, Date dtFechamento) {
    ConcurrentTaskScheduler tarefa = new ConcurrentTaskScheduler();
    tarefa.schedule(new PautaRuneable(idPauta, this), dtFechamento);
  }
}
