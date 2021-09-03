package com.teste.micro.handler;

import com.teste.micro.exception.RecordNotFoundException;
import com.teste.micro.helper.i18n.Translator;
import com.teste.micro.helper.web.dto.ErrorResponse;
import com.teste.micro.helper.web.dto.FieldError;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@RestController
public class GlobalExceptionHandler {

  private final Translator translator;

  /**
   * Handler for RecordNotFoundException.
   *
   * @param ex RecordNotFoundException
   * @return ErrorResponse
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = RecordNotFoundException.class)
  public ErrorResponse handlerRecordNotFoundException(RecordNotFoundException ex) {
    log.error(ex.getMessage());
    ErrorResponse response = new ErrorResponse();
    response.setError(translator.get("error.record_not_found"));
    response.setErrorDescription(ex.getMessage());
    return response;
  }

  /**
   * Handler for ConstraintViolationException.
   *
   * @param ex ConstraintViolationException
   * @return ErrorResponse
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = javax.validation.ConstraintViolationException.class)
  public ErrorResponse handlerConstraintViolationException(
      javax.validation.ConstraintViolationException ex) {
    log.error(ex.getMessage());
    var validErrors =
        ex.getConstraintViolations().stream()
            .map(error -> new FieldError(error.getPropertyPath().toString(), error.getMessage()))
            .collect(Collectors.toList());

    var response = new ErrorResponse();
    response.setError(translator.get("error.validation_errors"));
    response.setErrorDescription(translator.get("error.description.validation.errors"));
    response.setValidationErrors(validErrors);

    return response;
  }
}
