package mm.com.software100.springhello.hello.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.com.software100.springhello.hello.entities.ToDo;
import mm.com.software100.springhello.hello.entities.User;
import mm.com.software100.springhello.hello.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    
    @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers() {
        Iterable<User> iterable = userRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // login function
    public User login(String email, String password) {
        List<User> users = userRepository.findByEmail(email);
        if (users.size() == 0) {
            return null;
        }
        User user = users.get(0);

        /*
        // TODO: hash password and then check
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
        */

        

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
        
    }

}
