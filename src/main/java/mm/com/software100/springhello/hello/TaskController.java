package mm.com.software100.springhello.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @GetMapping("/tasks")
    // public String getTasks(@RequestParam(value = "page", defaultValue = "1")
    // Integer page) {
    public Map<String, Object> getTasks(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        // TODO : return fake list of tasks
        // return String.format("Good Morning %s!", page);
        // Simulated fake data
        List<Map<String, String>> tasks = new ArrayList<>();
        tasks.add(Map.of("id", "1", "name", "Task 1", "status", "Pending"));
        tasks.add(Map.of("id", "2", "name", "Task 2", "status", "Completed"));

        Map<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("tasks", tasks);

        return response;
    }

    @PostMapping("/tasks")
    public Map<String, String> createTask(@RequestParam(value = "name") String name) {
        // TODO : return fake task
        // return String.format("Task created %s!", page);
        // Simulate task creation
        Map<String, String> newTask = Map.of(
            "id", UUID.randomUUID().toString(),
            "name", name,
            "status", "Pending"
        );
        return newTask;
    }
}
