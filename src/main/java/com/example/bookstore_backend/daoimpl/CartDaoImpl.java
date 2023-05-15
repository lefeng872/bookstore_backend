package com.example.bookstore_backend.daoimpl;

import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart findCartByUserId(Integer userId) {
        return null;
    }
}
