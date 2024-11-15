package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;

import java.util.List;

public interface CartDao {
    public Integer getCartID(Integer userID);
    public Cart getCart(Integer userID);
    public Cart createCart(Integer userID);
    public List<CartItem> getCartItems(Integer userID);
    public Integer addCartItem(Integer id, Integer userID, Integer bookAmount);
    public Integer cancelCartItem(String isbn, Integer userID);
    public CartItem findCartItemByIdInUser(Integer id, Integer userID);
    public CartItem findCartItemByISBNInUser(String isbn, Integer userID);
}
