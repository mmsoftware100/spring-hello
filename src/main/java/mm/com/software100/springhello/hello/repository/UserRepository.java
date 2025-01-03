package mm.com.software100.springhello.hello.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mm.com.software100.springhello.hello.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);

    User findById(long id);
}