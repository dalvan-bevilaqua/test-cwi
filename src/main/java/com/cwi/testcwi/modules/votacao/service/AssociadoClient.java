package com.cwi.testcwi.modules.votacao.service;

import com.cwi.testcwi.feign.associado.AssociadoFeignConfig;
import com.cwi.testcwi.modules.votacao.associado.dto.StatusAssociadoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "associado",
    url = "https://user-info.herokuapp.com",
    configuration = AssociadoFeignConfig.class)
public interface AssociadoClient {

  @GetMapping("/users/{cpf}")
  StatusAssociadoDto findByCPF(@PathVariable String cpf);
}
