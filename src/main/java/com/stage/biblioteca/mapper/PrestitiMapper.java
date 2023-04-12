package com.stage.biblioteca.mapper;
import com.stage.biblioteca.dto.PrestitiDto;
import com.stage.biblioteca.entities.PrestitiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PrestitiMapper {
    PrestitiMapper INSTANCE = Mappers.getMapper(PrestitiMapper.class);
    PrestitiDto modelToDto(PrestitiEntity prestiti);
    PrestitiEntity dtoToModel(PrestitiDto prestitiDto);
}
