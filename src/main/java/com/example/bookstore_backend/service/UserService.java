package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.User;

public interface UserService {
    User findUserByUsernameAndPassword(String username, String password);
}
