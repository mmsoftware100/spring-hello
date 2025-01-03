package mm.com.software100.springhello.hello.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mm.com.software100.springhello.hello.entities.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    // You can define custom queries here if needed
    List<ToDo> findByName(String name);

    ToDo findById(long id);
}