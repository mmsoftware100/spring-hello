package mm.com.software100.springhello.hello.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import mm.com.software100.springhello.hello.entities.ToDo;
import mm.com.software100.springhello.hello.repository.ToDoRepository;

public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        Iterable<ToDo> iterable = toDoRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public ToDo getTaskById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public ToDo saveTask(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public boolean deleteTask(Long id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
