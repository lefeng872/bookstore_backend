package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Consumer;
import com.example.bookstore_backend.entity.SelfLookup;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.utility.Result;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {
    Result<User> login(String username, String password);
    Result<User> register(String username, String password, String email);
    Result<List<User>> getUsers();
    Result<List<User>> blockUser(Integer userID);
    Result<List<User>> unblockUser(Integer userID);

    Result<List<Consumer>> userStatistic(Timestamp start, Timestamp end);

    Result<SelfLookup> selfLookup(Integer userID, Timestamp start, Timestamp end);
}
