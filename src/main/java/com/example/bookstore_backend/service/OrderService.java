package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.entity.Order;
import com.example.bookstore_backend.entity.TypeCount;
import com.example.bookstore_backend.utility.Result;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public Result<List<Order>> getOrders(Integer userID);
    public void makeOrder(Integer userID);
    Result<List<Order>> getAllOrders();
    Result<List<Order>> searchOrders(Integer userID, String keyword, Timestamp start, Timestamp end);
    Result<List<Order>> searchAllOrders(Integer userID, String keyword, Timestamp start, Timestamp end);

    Result<List<TypeCount>> typeStatistic(Timestamp start, Timestamp end);

    Result<List<Order>> searchOrdersWithPage(Integer userID, String keyword, Timestamp start, Timestamp end, Integer pageIndex, Integer pageSize);

    Result<List<Order>> searchAllOrdersWithPage(Integer userID, String keyword, Timestamp start, Timestamp end, Integer pageIndex, Integer pageSize);
}
