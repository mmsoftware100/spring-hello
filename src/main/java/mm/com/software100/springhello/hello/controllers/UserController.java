package mm.com.software100.springhello.hello.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mm.com.software100.springhello.hello.entities.ToDo;
import mm.com.software100.springhello.hello.entities.User;
import mm.com.software100.springhello.hello.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createTask(@RequestParam(value = "name") String name,@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
        // User user = new User(name, email, password);
        // return userService.saveUser(user);
        try {
            User user = new User(name, email, password);
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (DataIntegrityViolationException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Email already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable Long id) {
        User user =  userService.getUserById(id);
        if(user == null){
            // throw new RuntimeException("User not found");
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(user);
    }

    // delete user endpoint
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> deleteTask(@PathVariable Long id) {
        // need to return json
        boolean status = userService.deleteUser(id);
        Map<String, String> response = new HashMap<>();
        if (status) {
            response.put("message", "User deleted successfully");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
        } else {
            response.put("message", "User not found");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password) {
        User user = userService.getUserById(id);
        if (user != null) {
            if (name != null) {
                user.setName(name);
            }
            if (email != null) {
                user.setEmail(email);
            }
            if (password != null) {
                user.setPassword(password);
            }
            User updatedUser = userService.saveUser(user);
            return ResponseEntity.ok(updatedUser); // Return the updated ToDo
        } else {
            // Return an error JSON with a message and a NOT_FOUND status
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    // login endpoint
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
        try {
            User loggedInuser = userService.login(email, password);
            if(loggedInuser == null){
                throw new RuntimeException("Invalid email or password");
            }
            return ResponseEntity.status(HttpStatus.OK).body(loggedInuser);
        } catch (Exception ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", ex.getMessage());
            // unauthenticated http status code
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}