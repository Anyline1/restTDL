package ru.anyline.resttdl.service;

import org.springframework.stereotype.Service;
import ru.anyline.resttdl.model.Company;
import ru.anyline.resttdl.repository.CompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    public Optional<Company> findById(Long id) {
        return companyRepo.findById(id);
    }

    public Company save(Company company) {
        return companyRepo.save(company);
    }

    public void deleteById(Long id) {
        companyRepo.deleteById(id);
    }
}
