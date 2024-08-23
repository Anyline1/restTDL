package ru.anyline.resttdl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.model.Task;
import ru.anyline.resttdl.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Management", description = "API for managing tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping
//    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks, with optional filtering and sorting")
    public List<Task> getAllTasks(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) String sortBy){

        Sort sort = Sort.by("createdAt");
        if ("title".equalsIgnoreCase(sortBy)) {
            sort = Sort.by("title");
        }
        if (completed != null) {
            return repository.findByCompleted(completed, sort);
        }
        return repository.findAll(sort);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = repository.findById(id);
        return task.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new task")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = repository.save(task);
        return ResponseEntity.ok(savedTask);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a task")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatetTask) {
        Optional<Task> task = repository.findById(id);

        if(task.isPresent()){
            Task var = task.get();
            var.setTitle(updatetTask.getTitle());
            var.setDescription(updatetTask.getDescription());
            var.setCompleted(updatetTask.getCompleted());
            return ResponseEntity.ok(repository.save(var));

        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        Optional<Task> task = repository.findById(id);

        if (task.isPresent()){
            repository.delete(task.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
