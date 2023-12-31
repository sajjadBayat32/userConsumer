package com.example.userConsumer.dao;

import com.example.userConsumer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
