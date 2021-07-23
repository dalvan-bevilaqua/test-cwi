package com.cwi.testcwi.modules.pauta.repository;

import com.cwi.testcwi.modules.pauta.entity.Pauta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Integer> {

  List<Pauta> findByflEmVotacao(String name);

}
