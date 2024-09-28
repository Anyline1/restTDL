package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anyline.resttdl.model.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
