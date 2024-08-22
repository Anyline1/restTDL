package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anyline.resttdl.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
