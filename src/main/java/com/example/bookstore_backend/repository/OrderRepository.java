package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Order;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderByOrderID(Integer orderID);
}
