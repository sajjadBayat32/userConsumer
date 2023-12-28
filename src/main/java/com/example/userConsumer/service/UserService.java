package com.example.userConsumer.service;

import com.example.userConsumer.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int userId);

    void deleteById(int userId);
}
