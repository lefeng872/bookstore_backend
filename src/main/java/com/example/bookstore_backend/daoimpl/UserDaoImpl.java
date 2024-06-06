package com.example.bookstore_backend.daoimpl;

import com.example.bookstore_backend.dao.UserDao;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.entity.UserAuth;
import com.example.bookstore_backend.repository.UserAuthRepository;
import com.example.bookstore_backend.repository.UserRepository;
import com.example.bookstore_backend.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAuthRepository userAuthRepository;
    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    @Override
    public User findUserByUserID(Integer userID) {
        return userRepository.findUserByUserID(userID);
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public int blockUser(Integer userID) {
        User user = userRepository.findUserByUserID(userID);
        user.setType(3);
        userRepository.save(user);
        return Constants.SUCCESS;
    }
    @Override
    public int unblockUser(Integer userID) {
        User user = userRepository.findUserByUserID(userID);
        user.setType(1);
        userRepository.save(user);
        return Constants.SUCCESS;
    }

    @Override
    public int login(String username, String password) {
        return userRepository.countByUsernameAndPassword(username, password);
    }

    @Override
    public UserAuth addUserAuth(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}