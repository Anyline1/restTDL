package ru.anyline.resttdl.service;

import ru.anyline.resttdl.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    void completeTask(Long taskId);
    List<Task> getTasks();
    Task getTaskById(Long taskId);
}

