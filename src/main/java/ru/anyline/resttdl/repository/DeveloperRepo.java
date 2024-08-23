package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anyline.resttdl.model.Developer;

public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
