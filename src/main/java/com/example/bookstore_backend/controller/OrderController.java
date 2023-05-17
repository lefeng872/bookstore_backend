package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.*;
import com.example.bookstore_backend.repository.OrderRepository;
import com.example.bookstore_backend.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/getOrder")
    public Order getOrder(Integer orderID) {
        return orderRepository.findOrderByOrderID(orderID);
    }
}
