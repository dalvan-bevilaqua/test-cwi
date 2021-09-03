package com.teste.micro.web;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldError implements Serializable {

  private static final long serialVersionUID = -2025785453687433560L;

  private String field;
  private String error;

}