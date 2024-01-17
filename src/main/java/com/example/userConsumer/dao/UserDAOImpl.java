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
    public User findByUserId(String userId) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userId=:userId", User.class);
        theQuery.setParameter("userId", userId);
        return theQuery.getSingleResult();
    }

    @Override
    public User save(User theUser) {
        return null;
    }

    @Override
    public void deleteById(String userId) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userId=:userId", User.class);
        theQuery.setParameter("userId", userId);
    }
}
