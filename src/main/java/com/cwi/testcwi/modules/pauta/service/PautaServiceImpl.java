package com.cwi.testcwi.modules.pauta.service;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;
import com.cwi.testcwi.modules.pauta.mapper.PautaMapper;
import com.cwi.testcwi.modules.pauta.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class PautaServiceImpl implements PautaService {

  private PautaRepository pautaRepository;
  private PautaMapper pautaMapper;

  @Override
  public PautaDto create(CreatePautaDto createPautaDto) {
    var pauta = pautaMapper.createPautaDtoToPauta(createPautaDto);
    return pautaMapper.pautaToPautaDto(pautaRepository.save(pauta));
  }
}
