package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
