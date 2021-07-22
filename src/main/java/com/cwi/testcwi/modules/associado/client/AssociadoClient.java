package com.cwi.testcwi.modules.associado.client;

import com.cwi.testcwi.modules.associado.dto.StatusAssociadoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "associado", url = "https://user-info.herokuapp.com")
public interface AssociadoClient {

  @GetMapping("/users/{cpf}")
  StatusAssociadoDto findById(@PathVariable Integer cpf);
}
