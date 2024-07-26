package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anyline.resttdl.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
