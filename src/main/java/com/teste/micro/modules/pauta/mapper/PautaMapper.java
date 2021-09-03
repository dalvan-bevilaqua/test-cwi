package com.teste.micro.modules.pauta.mapper;

import com.teste.micro.modules.pauta.dto.CreatePautaDto;
import com.teste.micro.modules.pauta.dto.PautaDto;
import com.teste.micro.modules.pauta.entity.Pauta;
import org.mapstruct.Mapper;

@Mapper
public interface PautaMapper {

  Pauta createPautaDtoToPauta(CreatePautaDto dto);

  PautaDto pautaToPautaDto(Pauta pauta);
}
