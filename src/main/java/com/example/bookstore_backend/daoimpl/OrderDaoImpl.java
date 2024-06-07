package com.example.bookstore_backend.daoimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.dao.OrderDao;
import com.example.bookstore_backend.dao.UserDao;
import com.example.bookstore_backend.entity.*;
import com.example.bookstore_backend.repository.BookRepository;
import com.example.bookstore_backend.repository.CartItemRepository;
import com.example.bookstore_backend.repository.OrderItemRepository;
import com.example.bookstore_backend.repository.OrderRepository;
import com.example.bookstore_backend.utility.Constants;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    CartDao cartDao;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Override
    public List<Order> getOrders(Integer userID) {
        User user = userDao.findUserByUserID(userID);
        Set<Order> orders = user.getOrders();
        return new ArrayList<>(orders);
    }

    @Override
    public List<Order> getUserOrdersWithTime(Integer userID, Timestamp start, Timestamp end) {
        return orderRepository.findOrdersByTimestampBetweenAndUserID(start, end, userID);
    }

    @Override
    public Order createOrder(Integer userID) {
        Order order = new Order();
        User user = userDao.findUserByUserID(userID);
        order.setUser(user);
        order.setTimestamp(new Timestamp(System.currentTimeMillis()));
        order = orderRepository.save(order);
        user.getOrders().add(order);
        return order;
    }
    @Override
    public void addOrderItem(Book book, Integer bookAmount, Order order) {
        book.setInventory(book.getInventory() - bookAmount);
        bookRepository.save(book);
        OrderItem orderItem = new OrderItem();
        orderItem.setIsbn(book.getIsbn());
        orderItem.setBookAmount(bookAmount);
        orderItem.setCurrentPrice(book.getPrice());
        orderItem.setOrder(order);
        orderItemRepository.save(orderItem);
        order.getOrderItems().add(orderItem);
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
