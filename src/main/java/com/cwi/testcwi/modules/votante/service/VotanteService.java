package com.cwi.testcwi.modules.votante.service;

public interface VotanteService {

  boolean validarSeJaVotou(String cpf, Integer idPauta);

  void gravarVotante(String cpf, Integer idPauta);
}
