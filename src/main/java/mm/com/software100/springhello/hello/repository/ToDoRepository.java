package mm.com.software100.springhello.hello.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mm.com.software100.springhello.hello.entities.ToDo;
/* we don't need to implement this interface, Spring  */
/*
 * that is what makes Spring Data JPA so powerful: You need not write an implementation of the repository interface. 
 * Spring Data JPA creates an implementation when you run the application.
 */
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    // You can define custom queries here if needed
    List<ToDo> findByName(String name);

    ToDo findById(long id);
}