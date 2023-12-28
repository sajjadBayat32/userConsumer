package com.example.userConsumer.rest;

import com.example.userConsumer.entity.User;
import com.example.userConsumer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable int userId) {
        return userService.findById(userId);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteById(@PathVariable int userId) {
        userService.deleteById(userId);
        return "Done";
    }
}
