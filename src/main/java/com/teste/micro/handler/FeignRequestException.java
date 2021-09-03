package com.teste.micro.handler;

import com.teste.micro.helper.web.dto.ErrorResponse;

public class FeignRequestException extends RuntimeException {

  private static final long serialVersionUID = -5050772147220489945L;

  private final ErrorResponse errorResponse;

  public FeignRequestException(ErrorResponse errorResponse) {
    super(errorResponse.getError());
    this.errorResponse = errorResponse;
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }

}
