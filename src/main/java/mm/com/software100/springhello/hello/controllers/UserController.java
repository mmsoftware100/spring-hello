package mm.com.software100.springhello.hello.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}