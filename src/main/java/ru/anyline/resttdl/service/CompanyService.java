package ru.anyline.resttdl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.DTO.CompanyDTO;
import ru.anyline.resttdl.mapper.ApplicationMapper;
import ru.anyline.resttdl.mapper.CompanyMapper;
import ru.anyline.resttdl.model.Application;
import ru.anyline.resttdl.model.Company;
import ru.anyline.resttdl.repository.CompanyRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    public List<CompanyDTO> findAll() {
        return companyRepo.findAll()
                .stream()
                .map(CompanyMapper.INSTANCE::toCompanyDTO)
                .collect(Collectors.toList());
    }

    public Optional<CompanyDTO> findById(Long id) {
        return companyRepo.findById(id)
                .map(CompanyMapper.INSTANCE::toCompanyDTO);
    }

    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = CompanyMapper.INSTANCE.toCompany(companyDTO);
        return CompanyMapper.INSTANCE.toCompanyDTO(companyRepo.save(company));
    }

    public void deleteById(Long id) {
        companyRepo.deleteById(id);
    }
}
