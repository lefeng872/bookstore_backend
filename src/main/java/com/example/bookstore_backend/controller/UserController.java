package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public User findUserByUsernameAndPassword(String username, String password) {
        return userService.findUserByUsernameAndPassword(username, password);
    }
}
