package ru.anyline.resttdl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.anyline.resttdl.DTO.DeveloperDTO;
import ru.anyline.resttdl.model.Developer;

@Mapper
public interface DeveloperMapper {

    DeveloperMapper INSTANCE = Mappers.getMapper(DeveloperMapper.class);

    DeveloperDTO toDeveloperDTO(Developer developer);

    Developer toDeveloper(DeveloperDTO developerDTO);

}
