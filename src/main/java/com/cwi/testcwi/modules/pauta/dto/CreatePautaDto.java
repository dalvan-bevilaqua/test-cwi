package com.cwi.testcwi.modules.pauta.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreatePautaDto implements Serializable {

  private static final long serialVersionUID = -1943266231376649403L;

  @NotNull(message = "{nome.not_null}")
  private String nome;

  @NotNull(message = "{descricao.not_null}")
  private String descricao;

  private String flEmVotacao;

  private Date dtFechamento;
}
