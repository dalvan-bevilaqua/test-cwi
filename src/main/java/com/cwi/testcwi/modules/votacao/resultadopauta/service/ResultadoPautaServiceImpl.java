package com.cwi.testcwi.modules.votacao.resultadopauta.service;

import com.cwi.testcwi.modules.pauta.dto.ResultadoPautaDto;
import com.cwi.testcwi.modules.votacao.resultadopauta.entity.ResultadoPauta;
import com.cwi.testcwi.modules.votacao.resultadopauta.repository.ResultadoPautaRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultadoPautaServiceImpl implements ResultadoPautaService {

  private final ResultadoPautaRespository resultadoPautaRespository;

  @Override
  public void salvarResultado(ResultadoPautaDto resultadoPautaDto) {

    resultadoPautaRespository.save(
        ResultadoPauta.builder()
            .dePauta(resultadoPautaDto.getDePauta())
            .nmPauta(resultadoPautaDto.getNmPauta())
            .idPauta(resultadoPautaDto.getIdPauta())
            .votosNao(resultadoPautaDto.getResultadoNao())
            .votosSim(resultadoPautaDto.getResultadoSim())
            .build());
  }
}
