package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.service.CartService;
import com.example.bookstore_backend.utility.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/getCartItems")
    public Result<List<CartItem>> getCartItems(@RequestBody Map<String, Integer> params) {
        Integer userID = params.get("userID");
        return cartService.getCartItems(userID);
    }
    @PostMapping("/addCartItem")
    public Result<List<CartItem>> addCartItem(@RequestBody Map<String, String> params) {
        return cartService.addCartItem(
                Integer.parseInt(params.get("id")),
                Integer.parseInt(params.get("userID")),
                Integer.parseInt(params.get("bookAmount"))
        );
    }
    @PostMapping("/cancelCartItem")
    public Result<List<CartItem>> cancelCartItem(@RequestBody Map<String, String> params) {
        return cartService.cancelCartItem(
                params.get("isbn"),
                Integer.parseInt(params.get("userID"))
        );
    }
}
