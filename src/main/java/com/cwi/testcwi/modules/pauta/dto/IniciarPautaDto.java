package com.cwi.testcwi.modules.pauta.dto;

import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IniciarPautaDto implements Serializable {

  private static final long serialVersionUID = 3990997572239913216L;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date dtFechamento;
}
