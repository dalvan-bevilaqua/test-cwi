package com.teste.micro.modules.votacao.resultadopauta;

import com.teste.micro.modules.pauta.dto.ResultadoPautaDto;
import com.teste.micro.modules.votacao.resultadopauta.service.ResultadoPautaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultadoConsumer {

  @Autowired
  private ResultadoPautaService resultadoPautaService;

  @RabbitListener(queues = "RESULTADO_VOTACAO")
  private void resultadoConsumer(ResultadoPautaDto resultadoPautaDto) {
    resultadoPautaService.salvarResultado(resultadoPautaDto);
    System.out.println("Resultado pauta salvo");
  }
}
