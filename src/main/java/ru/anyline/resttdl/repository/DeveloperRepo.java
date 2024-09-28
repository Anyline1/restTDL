package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anyline.resttdl.model.Developer;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
