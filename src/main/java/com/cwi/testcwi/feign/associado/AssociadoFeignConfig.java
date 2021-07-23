package com.cwi.testcwi.feign.associado;

import org.springframework.context.annotation.Bean;

public class AssociadoFeignConfig {

  @Bean
  public AssociadoErrorDecode alxErrorDecode() {
    return new AssociadoErrorDecode();
  }
}
