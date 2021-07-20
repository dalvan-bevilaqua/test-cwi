package com.cwi.testcwi.modules.votacao.dto;

import javax.validation.constraints.NotNull;

public class CreateVotoDto {

  @NotNull(message = "{voto.not_null}")
  private String voto;
}
