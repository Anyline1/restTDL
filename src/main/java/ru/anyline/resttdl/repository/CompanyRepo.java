package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anyline.resttdl.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
