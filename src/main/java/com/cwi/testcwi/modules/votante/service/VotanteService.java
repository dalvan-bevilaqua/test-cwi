package com.cwi.testcwi.modules.votante.service;

public interface VotanteService {

  boolean validarSeJaVotou(Integer cpf, Integer idPauta);

  void gravarVotante(Integer cpf, Integer idPauta);
}
