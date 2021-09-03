package com.teste.micro.modules.pauta.repository;

import com.teste.micro.modules.pauta.entity.Pauta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Integer> {

  List<Pauta> findByflEmVotacao(String name);

}
