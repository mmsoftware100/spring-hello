package mm.com.software100.springhello.hello.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mm.com.software100.springhello.hello.entities.ToDo;
import mm.com.software100.springhello.hello.services.ToDoService;

@RestController
public class ToDoJPAController {
    @Autowired
    private ToDoService toDoService;
 

    @GetMapping("/jpa-todos")
    public List<ToDo> getTasks(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return this.toDoService.getAllToDos();
    }

    @PostMapping("/jpa-todos")
    public ToDo createTask(@RequestParam(value = "name") String name) {
        ToDo toDo = new ToDo(name, "Pending");
        return this.toDoService.saveTask(toDo);
    }

}
