package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getOrders(Integer userID);
    public Order createOrder(Integer userID);
    public void addOrderItem(Book book, Integer bookAmount, Order order);
    List<Order> getAllOrders();
}