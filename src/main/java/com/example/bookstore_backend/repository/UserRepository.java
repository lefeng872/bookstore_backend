package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    User findUserByUserID(Integer userID);
    List<User> findAll();

    @Query(value = "SELECT COUNT(*) FROM user u JOIN userAuth ua ON u.userID = ua.userID WHERE u.username = :username AND ua.password = :password", nativeQuery = true)
    int countByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}