package com.cwi.testcwi.modules.votacao.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateVotoDto implements Serializable {

  private static final long serialVersionUID = -8316343551375725052L;

  @NotNull(message = "{id-pauta.not_null}")
  private Integer idPauta;

  @NotNull(message = "{voto.not_null}")
  private String voto;

  @NotNull(message = "{cpf.not_null}")
  private String cpf;
}
