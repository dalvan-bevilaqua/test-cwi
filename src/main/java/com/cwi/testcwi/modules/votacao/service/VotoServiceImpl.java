package com.cwi.testcwi.modules.votacao.service;

import com.cwi.testcwi.handler.BusinessException;
import com.cwi.testcwi.helper.i18n.Translator;
import com.cwi.testcwi.modules.enums.EnumSimNao;
import com.cwi.testcwi.modules.pauta.service.PautaService;
import com.cwi.testcwi.modules.votacao.dto.CreateVotoDto;
import com.cwi.testcwi.modules.votacao.dto.VotoDto;
import com.cwi.testcwi.modules.votacao.mapper.VotoMapper;
import com.cwi.testcwi.modules.votacao.repository.VotoRepository;
import com.cwi.testcwi.modules.votante.entity.Votante;
import com.cwi.testcwi.modules.votante.repository.VotanteRepository;
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
