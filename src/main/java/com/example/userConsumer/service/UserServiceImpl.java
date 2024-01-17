package com.example.userConsumer.service;

import com.example.userConsumer.dao.UserDAOImpl;
import com.example.userConsumer.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByUserId(String userId) {
        return userDAO.findByUserId(userId);
//        if (result) {
//            return result
//        } else {
//            throw new RuntimeException("User if not found");
//        }
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(String userId) {
        userDAO.deleteById(userId);
    }
}
