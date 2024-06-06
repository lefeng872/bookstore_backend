package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Order;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Override
    <S extends Order> S save(S entity);
    Order findOrderByOrderID(Integer orderID);
    @Override
    List<Order> findAll();
}
