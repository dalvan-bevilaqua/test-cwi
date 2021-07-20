package com.cwi.testcwi.modules.votacao.service;

import com.cwi.testcwi.modules.votacao.dto.CreateVotoDto;
import com.cwi.testcwi.modules.votacao.dto.VotoDto;

public interface VotoService {

  VotoDto create(CreateVotoDto dto);
}
