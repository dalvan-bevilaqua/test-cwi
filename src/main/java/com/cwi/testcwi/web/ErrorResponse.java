package com.cwi.testcwi.web;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

  private static final long serialVersionUID = 3336740711374771623L;

  private String error;
  private String errorDescription;
  private List<FieldError> validationErrors;

}
