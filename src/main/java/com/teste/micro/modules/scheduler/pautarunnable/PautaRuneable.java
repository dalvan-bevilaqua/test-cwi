package com.teste.micro.modules.scheduler.pautarunnable;

import com.teste.micro.modules.pauta.service.PautaService;

public class PautaRuneable implements Runnable {

  private PautaService pautaService;
  private Integer idPauta;

  public PautaRuneable(Integer idPauta, PautaService pautaService) {
    this.idPauta = idPauta;
    this.pautaService = pautaService;
  }

  public void run() {
    pautaService.finalizarPauta(idPauta);
    System.out.println("Fim de votação da Pauta: "+ idPauta);
  }
}
