package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.entity.UserAuth;

import java.util.List;


public interface UserDao {
    User findUserByUsername(String username);
    User findUserByUserID(Integer userID);
    User addUser(User user);
    List<User> getUsers();
    int blockUser(Integer userID);
    int unblockUser(Integer userID);
    int login(String username, String password);
    UserAuth addUserAuth(UserAuth userAuth);
}