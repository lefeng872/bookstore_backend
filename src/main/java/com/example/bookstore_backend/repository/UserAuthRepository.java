package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

}
