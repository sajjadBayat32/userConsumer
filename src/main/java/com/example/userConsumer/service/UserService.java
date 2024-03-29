package com.example.userConsumer.service;

import com.example.userConsumer.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUserId(String userId);

    User save(User theUser);

    void deleteById(String userId);
}
