package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anyline.resttdl.model.Application;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
