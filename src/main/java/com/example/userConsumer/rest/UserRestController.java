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
    public User findById(@PathVariable String userId) {
        User theUser = userService.findByUserId(userId);
        if (theUser == null) {
            throw new RuntimeException("User id not found");
        }
        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteById(@PathVariable String userId) {
        User theUser = userService.findByUserId(userId);
        if (theUser == null) {
            throw new RuntimeException("User id not found");
        }
        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }
}
