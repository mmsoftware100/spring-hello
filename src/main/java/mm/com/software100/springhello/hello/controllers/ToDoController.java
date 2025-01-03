package mm.com.software100.springhello.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mm.com.software100.springhello.hello.entities.Task;

@RestController
public class ToDoController {
    private final List<Task> tasks = new ArrayList<>();

    public ToDoController() {
        // Pre-populate with some sample tasks
        tasks.add(new Task("1", "Task 1", "Pending"));
        tasks.add(new Task("2", "Task 2", "Completed"));
    }

    @GetMapping("/todos")
    public List<Task> getTasks(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        // automatically convert Task (entity) to JSON response. 
        return tasks;
    }

    @GetMapping("/todos/{id}")
    public Task getTaskById(@PathVariable String id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @PostMapping("/todos")
    public Task createTask(@RequestParam(value = "name") String name) {
        Task newTask = new Task(UUID.randomUUID().toString(), name, "Pending");
        tasks.add(newTask);
        return newTask;
    }

    @PutMapping("/todos/{id}")
    public Task updateTask(@PathVariable String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "status", required = false) String status) {
        Optional<Task> optionalTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (name != null) {
                task.setName(name);
            }
            if (status != null) {
                task.setStatus(status);
            }
            return task;
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    @DeleteMapping("/todos/{id}")
    public Map<String, String> deleteTask(@PathVariable String id) {
        Optional<Task> optionalTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
        if (optionalTask.isPresent()) {
            tasks.remove(optionalTask.get());
            // return "Task deleted successfully";
            Map<String, String> response = new HashMap<>();
            response.put("message", "Task deleted successfully");
            return response;
        } else {
            throw new RuntimeException("Task not found");
        }
    }
}
