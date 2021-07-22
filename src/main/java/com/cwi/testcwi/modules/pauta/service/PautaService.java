package com.cwi.testcwi.modules.pauta.service;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.IniciarPautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;

public interface PautaService {

  PautaDto create(CreatePautaDto createPautaDto);

  void iniciarPauta(Integer idPauta, IniciarPautaDto iniciarPautaDto);

  void finalizarPauta(Integer idPauta);
}
