package com.teste.micro.modules.pauta.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPautaDto implements Serializable {

  private static final long serialVersionUID = 4196411605390771338L;

  private Integer idPauta;
  private String nmPauta;
  private String dePauta;
  private Integer resultadoSim;
  private Integer resultadoNao;
}
