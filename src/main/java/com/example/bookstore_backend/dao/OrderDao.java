package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.entity.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDao {
    public List<Order> getOrders(Integer userID);
    public List<Order> getUserOrdersWithTime(Integer userID, Timestamp start, Timestamp end);
    public Order createOrder(Integer userID);
    public void addOrderItem(Book book, Integer bookAmount, Order order);
    List<Order> getAllOrders();
}