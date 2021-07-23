package com.cwi.testcwi.modules.votante.repository;

import com.cwi.testcwi.modules.votante.entity.Votante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotanteRepository extends JpaRepository<Votante, Integer> {

  Votante findOneByCpfAndIdPauta(String cpf, Integer idPauta);
}
