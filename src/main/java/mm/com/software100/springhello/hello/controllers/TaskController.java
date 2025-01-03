package mm.com.software100.springhello.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final List<Map<String, String>> tasks = new ArrayList<>();

    public TaskController() {
        // Pre-populate with some sample tasks
        tasks.add(Map.of("id", "1", "name", "Task 1", "status", "Pending"));
        tasks.add(Map.of("id", "2", "name", "Task 2", "status", "Completed"));
    }

    @GetMapping("/tasks")
    public Map<String, Object> getTasks(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        Map<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("tasks", tasks);
        return response;
    }

    @GetMapping("/tasks/{id}")
    public Map<String, String> getTaskById(@PathVariable String id) {
        return tasks.stream()
                .filter(task -> task.get("id").equals(id))
                .findFirst()
                .orElse(Map.of("error", "Task not found"));
    }

    @PostMapping("/tasks")
    public Map<String, String> createTask(@RequestParam(value = "name") String name) {
        Map<String, String> newTask = new HashMap<>();
        newTask.put("id", UUID.randomUUID().toString());
        newTask.put("name", name);
        newTask.put("status", "Pending");
        tasks.add(newTask);
        return newTask;
    }

    @PutMapping("/tasks/{id}")
    public Map<String, String> updateTask(@PathVariable String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "status", required = false) String status) {
        for (Map<String, String> task : tasks) {
            if (task.get("id").equals(id)) {
                if (name != null) {
                    task.put("name", name);
                }
                if (status != null) {
                    task.put("status", status);
                }
                return task;
            }
        }
        return Map.of("error", "Task not found");
    }

    @DeleteMapping("/tasks/{id}")
    public Map<String, String> deleteTask(@PathVariable String id) {
        for (Map<String, String> task : tasks) {
            if (task.get("id").equals(id)) {
                tasks.remove(task);
                return Map.of("message", "Task deleted successfully");
            }
        }
        return Map.of("error", "Task not found");
    }
}
