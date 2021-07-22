package com.cwi.testcwi.modules.votacao.dto;

import javax.validation.constraints.NotNull;

public class CreateVotoDto {

  @NotNull(message = "{id-pauta.not_null}")
  private Integer idPauta;

  @NotNull(message = "{voto.not_null}")
  private String voto;

  @NotNull(message = "{cpf.not_null}")
  private Integer cpf;
}
