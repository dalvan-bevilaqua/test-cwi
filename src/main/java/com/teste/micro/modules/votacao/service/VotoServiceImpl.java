package com.teste.micro.modules.votacao.service;

import com.teste.micro.handler.BusinessException;
import com.teste.micro.helper.i18n.Translator;
import com.teste.micro.modules.enums.EnumSimNao;
import com.teste.micro.modules.pauta.service.PautaService;
import com.teste.micro.modules.votacao.dto.CreateVotoDto;
import com.teste.micro.modules.votacao.dto.VotoDto;
import com.teste.micro.modules.votacao.mapper.VotoMapper;
import com.teste.micro.modules.votacao.repository.VotoRepository;
import com.teste.micro.modules.votante.entity.Votante;
import com.teste.micro.modules.votante.repository.VotanteRepository;
import java.util.Date;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class VotoServiceImpl implements VotoService {

  private final VotoRepository votoRepository;
  private final VotanteRepository votanteRepository;
  private final VotoMapper votoMapper;
  private final AssociadoClient associadoClient;
  private final PautaService pautaService;
  private final Translator translator;

  private static final String APTO_AO_VOTO = "ABLE_TO_VOTE";

  @Override
  public VotoDto create(CreateVotoDto dto) {

    validaSeAssiciadoPodeVotar(dto.getCpf());
    validaSeJaVotou(dto.getCpf(), dto.getIdPauta());
    validaSePautaEstaAptaParaVotacao(dto.getIdPauta());
    validaVoto(dto.getVoto());

    var voto = votoMapper.createVotoDtoToVoto(dto);
    voto.setDtVoto(new Date());
    var votoSalvo = votoRepository.save(voto);
    votanteRepository.save(buildVotante(dto));
    return votoMapper.votoToVotoDto(votoSalvo);
  }

  private Votante buildVotante(CreateVotoDto dto) {
    return Votante.builder().idPauta(dto.getIdPauta()).cpf(dto.getCpf()).build();
  }

  private void validaSeAssiciadoPodeVotar(String cpf) {
    var statusAssociadoDto = associadoClient.findByCPF(cpf);
    if (APTO_AO_VOTO.equals(statusAssociadoDto.getStatus())) {
      return;
    }
    throw new BusinessException(translator.get("validation.associado.nao.pode.votar"));
  }

  private void validaSeJaVotou(String cpf, Integer idPauta) {
    var votante = votanteRepository.findOneByCpfAndIdPauta(cpf, idPauta);

    if (Objects.nonNull(votante)) {
      throw new BusinessException(translator.get("validation.associado.ja.votou"));
    }
  }

  private void validaSePautaEstaAptaParaVotacao(Integer idPauta) {
    pautaService.isAptaParaVotacao(idPauta);
  }

  private void validaVoto(String voto) {

    if (EnumSimNao.S.name().equals(voto)) {
      return;
    }

    if (EnumSimNao.N.name().equals(voto)) {
      return;
    }

    throw new BusinessException(translator.get("validation.parametro.incorreto"));
  }
}
