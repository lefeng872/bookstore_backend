package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findCartByCartID(Integer cartID);
}
