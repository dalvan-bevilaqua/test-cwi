package com.cwi.testcwi.modules.votacao.repository;

import com.cwi.testcwi.modules.votacao.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {}
