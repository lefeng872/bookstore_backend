package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Cart;

public interface CartService {
    Cart findCartByUserId(Integer userId);
}
