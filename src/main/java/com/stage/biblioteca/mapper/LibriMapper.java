package com.stage.biblioteca.mapper;

import com.stage.biblioteca.dto.LibriDto;
import com.stage.biblioteca.entities.LibriEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibriMapper {
    LibriMapper INSTANCE = Mappers.getMapper(LibriMapper.class);
 // @Mapping(source = "libri")
    LibriDto modelTODto(LibriEntity libri);
    LibriDto dtoT0Model(LibriDto libriDto);
}
