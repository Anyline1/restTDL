package ru.anyline.resttdl.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.model.Task;
import ru.anyline.resttdl.service.TaskServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Task Management", description = "API for managing tasks")
public class TaskController {


    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @PostMapping("/tasks/{id}/complete")
    public void completeTask(@PathVariable Long id) {
        taskService.completeTask(id);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }



}
