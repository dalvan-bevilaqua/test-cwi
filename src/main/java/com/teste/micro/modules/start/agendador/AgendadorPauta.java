package com.teste.micro.modules.start.agendador;

import com.teste.micro.modules.pauta.service.PautaService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgendadorPauta {

  @Autowired PautaService pautaService;

  @PostConstruct
  private void init() {
    pautaService.agendarTarefasDeFinalizacoes();
  }
}
