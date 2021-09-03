package com.teste.micro.modules.start.conections;

import javax.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "amqp.bpm.enabled", havingValue = "true")
public class RabbitMqConection {

  private static final String NOME_EXCHANGE = "amq.direct";
  private AmqpAdmin amqpAdmin;

  public RabbitMqConection(AmqpAdmin amqpAdmin) {
    this.amqpAdmin = amqpAdmin;
  }

  private Queue fila(String nmFila) {
    return new Queue(nmFila, true, false, false);
  }

  private DirectExchange trocaDireta() {
    return new DirectExchange(NOME_EXCHANGE);
  }

  private Binding relacionamento(Queue fila, DirectExchange troca) {
    return new Binding(
        fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
  }

  @PostConstruct
  private void adiciona() {
    Queue fila = this.fila(Fila.RESULTADO_VOTACAO.name());

    DirectExchange troca = this.trocaDireta();

    Binding ligacaoUm = this.relacionamento(fila, troca);

    // criando as filas no rabbit
    this.amqpAdmin.declareQueue(fila);

    // declara a exchage, se existir não cria
    this.amqpAdmin.declareExchange(troca);

    this.amqpAdmin.declareBinding(ligacaoUm);
  }
}
