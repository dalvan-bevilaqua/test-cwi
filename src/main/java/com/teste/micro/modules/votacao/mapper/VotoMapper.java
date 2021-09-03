package com.teste.micro.modules.votacao.mapper;

import com.teste.micro.modules.votacao.dto.CreateVotoDto;
import com.teste.micro.modules.votacao.dto.VotoDto;
import com.teste.micro.modules.votacao.entity.Voto;
import org.mapstruct.Mapper;

@Mapper
public interface VotoMapper {

  Voto createVotoDtoToVoto(CreateVotoDto dto);

  VotoDto votoToVotoDto(Voto voto);
}
