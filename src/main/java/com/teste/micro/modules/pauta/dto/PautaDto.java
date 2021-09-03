package com.teste.micro.modules.pauta.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PautaDto implements Serializable {

  private static final long serialVersionUID = 2234098328237689726L;
  private Integer id;
  private String nome;
  private String descricao;
  private String flEmVotacao;
  private Date dtFechamento;
}
