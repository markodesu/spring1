package service;

import model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    // Get all tasks
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Add a new task
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    // Delete task by ID
    public boolean deleteTask(int id) {
        Optional<Task> taskToDelete = tasks.stream().filter(task -> task.getId() == id).findFirst();
        if (taskToDelete.isPresent()) {
            tasks.remove(taskToDelete.get());
            return true;
        }
        return false;
    }
}
