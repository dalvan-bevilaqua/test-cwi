package com.teste.micro.modules.pauta.service;

import com.teste.micro.modules.pauta.dto.CreatePautaDto;
import com.teste.micro.modules.pauta.dto.IniciarPautaDto;
import com.teste.micro.modules.pauta.dto.PautaDto;
import com.teste.micro.modules.pauta.entity.Pauta;

public interface PautaService {

  PautaDto create(CreatePautaDto createPautaDto);

  void iniciarPauta(Integer idPauta, IniciarPautaDto iniciarPautaDto);

  void finalizarPauta(Integer idPauta);

  Pauta findById(Integer idPauta);

  void isAptaParaVotacao(Integer idPauta);

  void agendarTarefasDeFinalizacoes();
}
