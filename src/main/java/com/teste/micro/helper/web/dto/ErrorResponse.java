package com.teste.micro.helper.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse implements Serializable {

  private static final long serialVersionUID = 3336740711374771623L;

  private String error;
  private String errorDescription;
  private List<FieldError> validationErrors;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public List<FieldError> getValidationErrors() {
    return validationErrors;
  }

  public void setValidationErrors(List<FieldError> validationErrors) {
    this.validationErrors = validationErrors;
  }
}
