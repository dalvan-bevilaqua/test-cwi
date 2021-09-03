package com.teste.micro.modules.votante.repository;

import com.teste.micro.modules.votante.entity.Votante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotanteRepository extends JpaRepository<Votante, Integer> {

  Votante findOneByCpfAndIdPauta(String cpf, Integer idPauta);
}
