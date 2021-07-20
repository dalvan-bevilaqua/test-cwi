package com.cwi.testcwi.modules.pauta.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;

public class CreatePautaDto implements Serializable {

  private static final long serialVersionUID = -1943266231376649403L;
  @NotNull(message = "{nome.not_null}")
  private String nome;

  @NotNull(message = "{descricao.not_null}")
  private String descricao;

  @NotNull(message = "{flEmVotacao.not_null}")
  private String flEmVotacao;

  @NotNull(message = "{dtFechamento.not_null}")
  private Timestamp dtFechamento;
}
