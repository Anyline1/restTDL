package ru.anyline.resttdl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.model.Application;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    ApplicationDTO toApplicationDTO(Application application);
    Application toApplication(ApplicationDTO applicationDTO);

}
