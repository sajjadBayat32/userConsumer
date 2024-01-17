package com.example.userConsumer.dao;

import com.example.userConsumer.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findByUserId(String userId);

    void deleteById(String userId);

    User save(User theUser);
}
