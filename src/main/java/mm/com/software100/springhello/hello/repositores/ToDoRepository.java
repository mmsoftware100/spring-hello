package mm.com.software100.springhello.hello.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import mm.com.software100.springhello.hello.entities.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // You can define custom queries here if needed
}