package ru.anyline.resttdl;

import ru.anyline.resttdl.controller.TaskController;
import ru.anyline.resttdl.model.Task;
import ru.anyline.resttdl.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setTitle("Test Task");

        when(taskRepository.save(task)).thenReturn(task);

        ResponseEntity<Task> response = taskController.createTask(task);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(task, response.getBody());
    }

    @Test
    public void testGetTaskById() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(task, response.getBody());
    }

    @Test
    public void testGetTaskById_NotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateTask() {
        Task existingTask = new Task();
        existingTask.setId(1L);
        existingTask.setTitle("Existing Task");

        Task updatedTaskDetails = new Task();
        updatedTaskDetails.setTitle("Updated Task");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(existingTask);

        ResponseEntity<Task> response = taskController.updateTask(1L, updatedTaskDetails);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Updated Task", response.getBody().getTitle());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(taskRepository, times(1)).delete(task);
    }

    @Test
    public void testDeleteTask_NotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertEquals(404, response.getStatusCodeValue());
    }
}
