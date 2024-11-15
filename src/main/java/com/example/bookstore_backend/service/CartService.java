package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.utility.Result;

import java.util.List;

public interface CartService {
    public Result<Cart> createCart(Integer userID);
    public Result<List<CartItem>> getCartItems(Integer userID);
    public Result<List<CartItem>> addCartItem(Integer id, Integer userID, Integer bookAmount);
    public Result<List<CartItem>> cancelCartItem(String isbn, Integer userID);
}
