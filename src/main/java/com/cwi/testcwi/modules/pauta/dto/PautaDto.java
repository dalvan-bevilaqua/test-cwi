package com.cwi.testcwi.modules.pauta.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class PautaDto implements Serializable {

  private static final long serialVersionUID = 2234098328237689726L;
  private Integer id;
  private String nome;
  private String descricao;
  private String flEmVotacao;
  private Timestamp dtFechamento;
}
