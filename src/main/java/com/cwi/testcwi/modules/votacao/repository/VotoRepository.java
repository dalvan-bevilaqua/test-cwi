package com.cwi.testcwi.modules.votacao.repository;

import com.cwi.testcwi.modules.votacao.entity.Voto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
  List<Voto> findByIdPauta(Integer idPauta);
}
