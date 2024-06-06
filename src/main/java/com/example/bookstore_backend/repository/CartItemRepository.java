package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findCartItemByCart(Cart cart);
}
