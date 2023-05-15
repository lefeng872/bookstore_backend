package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.User;

import java.util.List;


public interface UserDao {
    User findUserByUsernameAndPassword(String username, String password);
}