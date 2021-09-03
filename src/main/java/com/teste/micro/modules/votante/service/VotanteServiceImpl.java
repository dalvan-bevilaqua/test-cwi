package com.teste.micro.modules.votante.service;

import com.teste.micro.modules.votante.entity.Votante;
import com.teste.micro.modules.votante.repository.VotanteRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class VotanteServiceImpl implements VotanteService {

  private final VotanteRepository votanteRepository;

  @Override
  public boolean validarSeJaVotou(String cpf, Integer idPauta) {
    var votante = votanteRepository.findOneByCpfAndIdPauta(cpf, idPauta);
    return Objects.isNull(votante);
  }

  @Override
  public void gravarVotante(String cpf, Integer idPauta) {
    votanteRepository.save(Votante.builder().cpf(cpf).idPauta(idPauta).build());
  }
}
