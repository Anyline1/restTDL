package ru.anyline.resttdl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.anyline.resttdl.DTO.CompanyDTO;
import ru.anyline.resttdl.model.Company;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    CompanyDTO toCompanyDTO(Company company);
    Company toCompany(CompanyDTO companyDTO);
}
