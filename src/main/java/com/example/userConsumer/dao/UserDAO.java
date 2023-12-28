package com.example.userConsumer.dao;

import com.example.userConsumer.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int userId);

    void deleteById(int userId);
}
