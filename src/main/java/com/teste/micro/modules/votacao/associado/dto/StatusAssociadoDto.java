package com.teste.micro.modules.votacao.associado.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusAssociadoDto implements Serializable {

  private static final long serialVersionUID = -6831736261813020217L;
  private String status;

}
