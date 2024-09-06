package ru.anyline.resttdl.service;

import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.DTO.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public List<CompanyDTO> findAll();
    public Optional<CompanyDTO> findById(Long id);
    public CompanyDTO save(CompanyDTO companyDTO);
    public void deleteById(Long id);
}
