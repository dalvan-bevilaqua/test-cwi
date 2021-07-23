package com.cwi.testcwi.modules.pauta.service.fila;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

  @Autowired private RabbitTemplate rabbitTemplate;

  public void enviarMensagem(String nmFila, Object mensagem) {
    this.rabbitTemplate.convertAndSend(nmFila, mensagem);
  }
}
