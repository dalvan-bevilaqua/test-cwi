package com.cwi.testcwi.modules.votacao.service;

import com.cwi.testcwi.modules.votacao.dto.CreateVotoDto;
import com.cwi.testcwi.modules.votacao.dto.VotoDto;
import com.cwi.testcwi.modules.votacao.mapper.VotoMapper;
import com.cwi.testcwi.modules.votacao.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class VotoServiceImpl implements VotoService {

  private final VotoRepository votoRepository;
  private final VotoMapper votoMapper;

  @Override
  public VotoDto create(CreateVotoDto dto) {

    var voto = votoMapper.createVotoDtoToVoto(dto);
    return votoMapper.votoToVotoDto(votoRepository.save(voto));

  }
}
