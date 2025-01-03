package mm.com.software100.springhello.hello.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import mm.com.software100.springhello.hello.entities.ToDo;
import mm.com.software100.springhello.hello.repository.ToDoRepository;

public class ToDoService {
    /*
     * @Autowired is a Spring Framework annotation used for dependency injection. 
     * It allows Spring to automatically inject the required dependencies into a class. 
     * When you annotate a field, constructor, or setter method with @Autowired, 
     * Spring's dependency injection mechanism will automatically provide the required bean.
     */
    @Autowired
    private ToDoRepository toDoRepository;

    /*
     * In the context of Spring Framework, a bean is an object that is managed by the Spring IoC (Inversion of Control) container. 
     * Beans are the fundamental building blocks of a Spring application. 
     * They are created, configured, and managed by the Spring container.
     */

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
