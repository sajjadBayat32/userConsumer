package com.example.userConsumer.service;

import com.example.userConsumer.entity.User;
import jakarta.transaction.Transactional;
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

    @Override
    public User findById(int userId) {
        return userDAO.findById(userId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int userId) {
        userDAO.deleteById(userId);
    }
}
