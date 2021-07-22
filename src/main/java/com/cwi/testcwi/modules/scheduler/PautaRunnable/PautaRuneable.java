package com.cwi.testcwi.modules.scheduler.PautaRunnable;

import com.cwi.testcwi.modules.pauta.service.PautaService;

public class PautaRuneable implements Runnable {

  private PautaService pautaService;
  private Integer idPauta;

  public PautaRuneable(Integer idPauta, PautaService pautaService) {
    this.idPauta = idPauta;
    this.pautaService = pautaService;
  }

  public void run() {
    System.out.println("Fim de votação da Pauta: "+ idPauta);
    pautaService.finalizarPauta(idPauta);
  }
}
