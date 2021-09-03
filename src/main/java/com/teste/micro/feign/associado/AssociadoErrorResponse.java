package com.teste.micro.feign.associado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociadoErrorResponse {

  private static final long serialVersionUID = 9003734398594655734L;

  private String message;
}
