package com.cwi.testcwi.modules.pauta.controller;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.IniciarPautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;
import com.cwi.testcwi.modules.pauta.service.PautaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/pauta")
public class PautaController {

  private final PautaService pautaService;

  @PostMapping
  public PautaDto create(@RequestBody CreatePautaDto createPautaDto) {
    return pautaService.create(createPautaDto);
  }

  @PostMapping("/{idPauta}/iniciar")
  public void iniciarPauta(
      @PathVariable("idPauta") Integer idPauta,
      @RequestBody IniciarPautaDto iniciarPautaDto) {
    pautaService.iniciarPauta(idPauta, iniciarPautaDto);
  }
}
