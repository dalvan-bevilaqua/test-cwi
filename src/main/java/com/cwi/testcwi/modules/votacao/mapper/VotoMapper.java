package com.cwi.testcwi.modules.votacao.mapper;

import com.cwi.testcwi.modules.votacao.dto.CreateVotoDto;
import com.cwi.testcwi.modules.votacao.dto.VotoDto;
import com.cwi.testcwi.modules.votacao.entity.Voto;
import org.mapstruct.Mapper;

@Mapper
public interface VotoMapper {

  Voto createVotoDtoToVoto(CreateVotoDto dto);

  VotoDto votoToVotoDto(Voto voto);
}
