package com.stage.biblioteca.mapper;
import com.stage.biblioteca.dto.LibriDto;
import com.stage.biblioteca.entities.LibriEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface LibriMapper {
    LibriMapper INSTANCE = Mappers.getMapper(LibriMapper.class);
    LibriDto modelToDto(LibriEntity libri);
    LibriEntity dtoToModel(LibriDto libriDto);
}
