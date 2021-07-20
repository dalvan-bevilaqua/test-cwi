package com.cwi.testcwi.modules.pauta.mapper;

import com.cwi.testcwi.modules.pauta.dto.CreatePautaDto;
import com.cwi.testcwi.modules.pauta.dto.PautaDto;
import com.cwi.testcwi.modules.pauta.entity.Pauta;
import org.mapstruct.Mapper;

@Mapper
public interface PautaMapper {

  Pauta createPautaDtoToPauta(CreatePautaDto dto);

  PautaDto pautaToPautaDto(Pauta pauta);
}
