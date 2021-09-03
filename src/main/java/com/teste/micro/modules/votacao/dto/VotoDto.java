package com.teste.micro.modules.votacao.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoDto {

  private Integer id;
  private Integer idPauta;
  private String voto;
  private Date dtVoto;
}
