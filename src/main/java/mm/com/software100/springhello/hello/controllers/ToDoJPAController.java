package mm.com.software100.springhello.hello.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    @GetMapping("/jpa-todos/{id}")
    public ToDo getTaskById(@PathVariable Long id) {
        return this.toDoService.getTaskById(id);
    }

    

    @PutMapping("/jpa-todos/{id}")
    public ToDo updateTask(@PathVariable Long id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "status", required = false) String status) {
        ToDo toDo = this.toDoService.getTaskById(id);
        if (toDo != null) {
            toDo.setName(name);
            if(status != null){
                toDo.setStatus(status);
            }
            return this.toDoService.saveTask(toDo);
        } else {
            return null;
        }
    }

    @DeleteMapping("/jpa-todos/{id}")
    public ResponseEntity<Map<String, String>> deleteTask(@PathVariable Long id) {
        // need to return json
        boolean status = this.toDoService.deleteTask(id);
        Map<String, String> response = new HashMap<>();
        if (status) {
            response.put("message", "Task deleted successfully");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
        } else {
            response.put("message", "Task not found");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        
    }

}
