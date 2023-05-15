package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Cart;

public interface CartDao {
    Cart findCartByUserId(Integer userId);
}
