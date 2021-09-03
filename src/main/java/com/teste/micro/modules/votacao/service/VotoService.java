package com.teste.micro.modules.votacao.service;

import com.teste.micro.modules.votacao.dto.CreateVotoDto;
import com.teste.micro.modules.votacao.dto.VotoDto;

public interface VotoService {

  VotoDto create(CreateVotoDto dto);
}
