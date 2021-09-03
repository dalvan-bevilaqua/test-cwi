package com.teste.micro.modules.votacao.controller;

import com.teste.micro.modules.votacao.dto.CreateVotoDto;
import com.teste.micro.modules.votacao.dto.VotoDto;
import com.teste.micro.modules.votacao.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/voto")
public class VotoController {

  private final VotoService votoService;

  @PostMapping
  public VotoDto create(@RequestBody CreateVotoDto dto) {
    return votoService.create(dto);
  }
}
