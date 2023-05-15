package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/getCart")
    public Cart findCartByUserId(Integer userId) {
        return cartService.findCartByUserId(userId);
    }
}
