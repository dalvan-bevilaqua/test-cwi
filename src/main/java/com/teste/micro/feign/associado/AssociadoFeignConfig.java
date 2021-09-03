package com.teste.micro.feign.associado;

import org.springframework.context.annotation.Bean;

public class AssociadoFeignConfig {

  @Bean
  public AssociadoErrorDecode alxErrorDecode() {
    return new AssociadoErrorDecode();
  }
}
