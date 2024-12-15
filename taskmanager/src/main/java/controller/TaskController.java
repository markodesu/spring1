package controller;

import model.Task;
import service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET /tasks - Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // POST /tasks - Add a new task
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);
        return ResponseEntity.status(201).body(newTask); // 201 Created
    }

    // DELETE /tasks/{id} - Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        boolean isDeleted = taskService.deleteTask(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Task deleted successfully");
        }
        return ResponseEntity.status(404).body("Task not found");
    }
}
