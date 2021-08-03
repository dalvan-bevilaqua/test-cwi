package com.cwi.testcwi.modules.pauta.integracao;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;
import com.cwi.testcwi.modules.pauta.service.PautaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/pauta")
public class PautaApiController {

  private final PautaService pautaService;

  @PostMapping
  @Valid
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Create Pauta", code = 200, tags = "test")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Create Pauta"),
    @ApiResponse(code = 400, message = "Erro ao criar pauta"),
    @ApiResponse(code = 401, message = "Unauthorized"),
    @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Not Found")
  })
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "nome",
        dataType = "string",
        paramType = "query",
        value = "Nome pauta",
        required = true),
    @ApiImplicitParam(
        name = "descricao",
        dataType = "string",
        paramType = "query",
        value = "Descrição Pauta",
        required = true),
    @ApiImplicitParam(
        name = "flEmVotacao",
        dataType = "string",
        paramType = "query",
        value = "em votação (s/n)"),
    @ApiImplicitParam(
        name = "dtFechamento",
        dataType = "date",
        paramType = "query",
        value = "Data de fechamento (2021-07-21T22:45:35.566-0300)",
        defaultValue = "0")
  })
  public PautaDto create(@RequestBody CreatePautaDto createPautaDto) {
    return pautaService.create(createPautaDto);
  }
}
