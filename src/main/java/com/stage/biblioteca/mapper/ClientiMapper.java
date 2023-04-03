package com.stage.biblioteca.mapper;

import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.entities.ClientiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientiMapper {
    ClientiMapper INSTANCE = Mappers.getMapper(ClientiMapper.class);
    ClientiDto modelToDto(ClientiEntity clienti);
    ClientiEntity dtoToModel(ClientiDto clientiDto);
}
