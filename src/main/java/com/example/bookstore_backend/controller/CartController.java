package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.service.CartService;
import com.example.bookstore_backend.utility.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/getCartItems")
    public Result<List<CartItem>> getCartItems(@RequestParam int userID) {
        return cartService.getCartItems(userID);
    }
    @GetMapping("/addCartItem")
    public Result<List<CartItem>> addCartItem(@RequestParam String isbn, @RequestParam String userID, @RequestParam String bookAmount) {
        return cartService.addCartItem(
                isbn,
                Integer.parseInt(userID),
                Integer.parseInt(bookAmount)
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
