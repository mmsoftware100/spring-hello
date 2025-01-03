package mm.com.software100.springhello.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import mm.com.software100.springhello.hello.entities.Task;

@RestController
public class ToDoController {
    private final List<Task> tasks = new ArrayList<>();
}
