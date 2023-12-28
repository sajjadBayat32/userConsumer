package com.example.userConsumer.service;

import com.example.userConsumer.dao.UserDAO;
import com.example.userConsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
