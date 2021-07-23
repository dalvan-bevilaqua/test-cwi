package com.cwi.testcwi.feign.associado;

import com.cwi.testcwi.handler.FeignRequestException;
import com.cwi.testcwi.helper.web.dto.ErrorResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Data
public class AssociadoErrorDecode implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    var errorResponse =
        ErrorResponse.builder().error("Erro ao acessar o serviço de Associado").build();

    try {
      if (response.status() == 404) {
        errorResponse = ErrorResponse.builder().error("Associado não encontrado para o CPF informado").build();
      }
    } catch (Exception e) {
      throw new FeignRequestException(errorResponse);
    }
    throw new FeignRequestException(errorResponse);
  }
}
