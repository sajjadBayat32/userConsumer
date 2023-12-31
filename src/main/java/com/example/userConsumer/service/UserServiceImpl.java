package com.example.userConsumer.service;

import com.example.userConsumer.dao.UserRepository;
import com.example.userConsumer.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int userId) {
        Optional<User> result = userRepository.findById(userId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("User if not found");
        }
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }
}
