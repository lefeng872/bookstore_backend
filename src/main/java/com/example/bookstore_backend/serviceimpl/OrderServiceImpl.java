package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.dao.OrderDao;
import com.example.bookstore_backend.entity.*;
import com.example.bookstore_backend.service.OrderService;
import com.example.bookstore_backend.utility.Constants;
import com.example.bookstore_backend.utility.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private BookDao bookDao;
    private Result<List<CartItem>> cartItemListResult = new Result<>();
    private Result<List<Order>> orderListResult = new Result<>();
    @Override
    public Result<List<Order>> getOrders(Integer userID) {
        if (userID == null) {
            orderListResult.setCode(Constants.FAIL);
            orderListResult.setMsg("please login!");
            orderListResult.setDetail(null);
            return orderListResult;
        }
        List<Order> res = orderDao.getOrders(userID);
        if (res == null) {
            orderListResult.setCode(Constants.FAIL);
            orderListResult.setMsg("Empty order!");
            orderListResult.setDetail(null);
        } else {
            orderListResult.setCode(Constants.SUCCESS);
            orderListResult.setMsg("Success to get Orders");
            orderListResult.setDetail(res);
        }
        return orderListResult;
    }

    @Override
    public void makeOrder(Integer userID) {
        List<CartItem> cartItems = cartDao.getCartItems(userID);
        if (cartItems.isEmpty()) {
            // "Empty Cart"
        } else {
            Order order = orderDao.createOrder(userID);
            if (order != null) {
                for (CartItem item : cartItems) {
                    Book book = bookDao.findBookByISBN(item.getIsbn());
                    if (book.getInventory() >= item.getBookAmount()) {
                        orderDao.addOrderItem(book, item.getBookAmount(), order);
                        cartDao.cancelCartItem(item.getIsbn(), userID);
                    }
                }
                // "Your Order Is Finished"
            } else {
                // "Create Order Failed"
            }
        }
    }

    @Override
    public Result<List<Order>> getAllOrders() {
        List<Order> orders = orderDao.getAllOrders();
        if (orders == null) {
            orderListResult.setCode(Constants.FAIL);
            orderListResult.setMsg("No orders");
            orderListResult.setDetail(null);
        } else {
            orderListResult.setCode(Constants.SUCCESS);
            orderListResult.setMsg("Success to get orders");
            orderListResult.setDetail(orders);
        }
        return orderListResult;
    }

    @Override
    public Result<List<Order>> searchOrders(Integer userID, String keyword, Timestamp start, Timestamp end) {
        List<Order> orders = orderDao.getUserOrdersWithTime(userID, start, end);
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order: orders) {
            boolean keyword_flag = false;
            for (OrderItem orderItem : order.getOrderItems()) {
                Book book = bookDao.findBookByISBN(orderItem.getIsbn());
                if (book == null) continue;
                String bookName = book.getName();
                if (bookName.matches(".*" + keyword + ".*")) {
                    keyword_flag = true;
                    break;
                }
            }
            if (keyword_flag) {
                filteredOrders.add(order);
            }
        }
        if (orders.isEmpty()) {
            orderListResult.setCode(Constants.FAIL);
            orderListResult.setMsg("Empty order!");
            orderListResult.setDetail(null);
        } else {
            orderListResult.setCode(Constants.SUCCESS);
            orderListResult.setMsg("Success to get Orders");
            orderListResult.setDetail(filteredOrders);
        }
        return orderListResult;
    }

    @Override
    public Result<List<Order>> searchAllOrders(Integer userID, String keyword, Timestamp start, Timestamp end) {
        List<Order> orders = orderDao.getAllOrders();
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            Timestamp orderTimestamp = order.getTimestamp();
            if (orderTimestamp.after(start) && orderTimestamp.before(end)) {
                boolean keyword_flag = false;
                for (OrderItem orderItem : order.getOrderItems()) {
                    Book book = bookDao.findBookByISBN(orderItem.getIsbn());
                    if (book == null) continue;
                    String bookName = book.getName();
                    System.out.println(bookName);
                    if (bookName.matches(".*" + keyword + ".*")) {
                        System.out.println(bookName + "matches" + keyword + "!");
                        keyword_flag = true;
                        break;
                    }
                }
                if (keyword_flag) filteredOrders.add(order);
            }
        }

        if (filteredOrders.isEmpty()) {
            orderListResult.setCode(Constants.FAIL);
            orderListResult.setMsg("Empty order!");
            orderListResult.setDetail(null);
        } else {
            orderListResult.setCode(Constants.SUCCESS);
            orderListResult.setMsg("Success to get Orders");
            orderListResult.setDetail(filteredOrders);
        }
        return orderListResult;
    }

    @Override
    public Result<List<TypeCount>> typeStatistic(Timestamp start, Timestamp end) {
        List<TypeCount> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<Book> books = bookDao.getBooks();
        List<Order> orders = orderDao.getAllOrders();
        for (Order order : orders) {
            Timestamp orderTimestamp = order.getTimestamp();
            if (orderTimestamp.after(start) && orderTimestamp.before(end)) {
                Set<OrderItem> orderItems = order.getOrderItems();
                for (OrderItem item: orderItems) {
                    System.out.println("this book is counted! isbn=" + item.getIsbn() + "with amount" + item.getBookAmount() + "\n start matching!");
                    for (Book book: books) {
                        System.out.println("next book isbn: " + book.getIsbn());
                        if (Objects.equals(book.getIsbn(), item.getIsbn())) {
                            System.out.println("Matched! isbn=" + item.getIsbn() + "with amount" + item.getBookAmount() + "with type" + book.getType());
                            if (map.get(book.getType()) == null) {
                                map.put(book.getType(), item.getBookAmount());
                            } else {
                                map.put(book.getType(), map.get(book.getType()) + item.getBookAmount());
                            }
                        }
                    }
                }
            }
        }
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            TypeCount typeCount = new TypeCount();
            typeCount.setType(key);
            typeCount.setNumber(value);
            list.add(typeCount);
            System.out.println("Key: " + key + ", Value: " + value);
        }
        Result<List<TypeCount>> result = new Result<>();
        result.setMsg("typeStatistic ok");
        result.setCode(Constants.SUCCESS);
        result.setDetail(list);
        System.out.println(result.getDetail());
        return result;
    }

    public static String convertMapToJson(Map<String, Integer> map) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }
}
