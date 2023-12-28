package com.example.userConsumer.dao;

import com.example.userConsumer.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User findById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void deleteById(int userId) {
        System.out.println(userId);
        User theUser = entityManager.find(User.class, userId);
        entityManager.remove(theUser);
    }
}
