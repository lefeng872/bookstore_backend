package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsernameAndPassword(String username, String password);
}