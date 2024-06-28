package com.example.bookstore_backend.serviceimpl;
import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.dao.OrderDao;
import com.example.bookstore_backend.dao.UserDao;
import com.example.bookstore_backend.entity.*;
import com.example.bookstore_backend.service.UserService;
import com.example.bookstore_backend.utility.Constants;
import com.example.bookstore_backend.utility.Result;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private BookDao bookDao;
    private Result<User> userResult = new Result<>();
    private Result<List<User>> userListResult = new Result<>();
    @Override
    public Result<User> login(String username, String password) {
        User findUser = userDao.findUserByUsername(username);
        // todo
        int count = userDao.login(username, password);
        if (count == 0) {
            userResult.setCode(Constants.FAIL);
            userResult.setMsg("login fail");
            userResult.setDetail(null);
        } else {
            userResult.setCode(Constants.SUCCESS);
            userResult.setMsg("login succeed");
            userResult.setDetail(userDao.findUserByUsername(username));
        }
        return userResult;
    }
    @Override
    public Result<User> register(String username, String password, String email) {
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            user = new User();
            user.setType(1);
            user.setUsername(username);
            user.setEmail(email);
            user = userDao.addUser(user);
            if (user == null) {
                userResult.setCode(Constants.FAIL);
                userResult.setMsg("Add User Failed!");
                userResult.setDetail(null);
            } else {
                // todo 插入成功
                userResult.setCode(Constants.SUCCESS);
                userResult.setMsg("Success to Register!");
                cartDao.createCart(user.getUserID());
                UserAuth userAuth = new UserAuth();
                userAuth.setUser(user);
                userAuth.setPassword(password);
                userDao.addUserAuth(userAuth);
                userResult.setDetail(user);
            }
        } else {
            userResult.setCode(Constants.FAIL);
            userResult.setMsg("Repeated username!");
            userResult.setDetail(null);
        }
        return userResult;
    }
    @Override
    public Result<List<User>> getUsers() {
        List<User> users = userDao.getUsers();
        if (users == null) {
            userListResult.setCode(Constants.FAIL);
            userListResult.setMsg("No users");
            userListResult.setDetail(null);
        } else {
            userListResult.setCode(Constants.SUCCESS);
            userListResult.setMsg("Found users");
            userListResult.setDetail(users);
        }
        return userListResult;
    }
    @Override
    public Result<List<User>> blockUser(Integer userID) {
        userListResult.setCode(userDao.blockUser(userID));
        if (userListResult.getCode() == Constants.SUCCESS) {
            userListResult.setMsg("Successfully blocked");
        } else {
            userListResult.setMsg("Failed to block");
        }
        userListResult.setDetail(userDao.getUsers());
        return userListResult;
    }
    @Override
    public Result<List<User>> unblockUser(Integer userID) {
        userListResult.setCode(userDao.unblockUser(userID));
        if (userListResult.getCode() == Constants.SUCCESS) {
            userListResult.setMsg("Successfully unblocked");
        } else {
            userListResult.setMsg("Failed to unblock");
        }
        userListResult.setDetail(userDao.getUsers());
        return userListResult;
    }

    @Override
    public Result<List<Consumer>> userStatistic(Timestamp start, Timestamp end) {
        System.out.println("In userStatistic");
        List<Consumer> list = new ArrayList<>();
        List<User> users = userDao.getUsers();
        for (User user: users) {
            Consumer consumer = new Consumer();
            consumer.setUsername(user.getUsername());
            consumer.setTotal(BigDecimal.valueOf(0.0));
            // todo
            Set<Order> orderSet = user.getOrders();
            for (Order order: orderSet) {
                Timestamp orderTimestamp = order.getTimestamp();
                if (orderTimestamp.after(start) && orderTimestamp.before(end)) {
                    consumer.setTotal(consumer.getTotal().add(order.compute_total()));
                }
            }
            list.add(consumer);
        }
        Result<List<Consumer>> result = new Result<>();
        result.setCode(Constants.SUCCESS);
        result.setMsg("get ok");
        result.setDetail(list);
        return result;
    }

    @Override
    public Result<SelfLookup> selfLookup(Integer userID, Timestamp start, Timestamp end) {
        Result<SelfLookup> result = new Result<>();
        SelfLookup selfLookup = new SelfLookup();
        selfLookup.setTotalNum(0);
        selfLookup.setTotalMoney(BigDecimal.valueOf(0));
        List<SelfLookup.Tuple> bookInfo = new ArrayList<>();

        List<Order> orderList = orderDao.getUserOrdersWithTime(userID, start, end);
        for (Order order: orderList) {
            Set<OrderItem> orderItemSet = order.getOrderItems();
            selfLookup.setTotalMoney(selfLookup.getTotalMoney().add(order.compute_total()));
            for (OrderItem item: orderItemSet) {
                selfLookup.setTotalNum(selfLookup.getTotalNum() + item.getBookAmount());
                Boolean find = false;
                for (SelfLookup.Tuple tuple: bookInfo) {
                    if (Objects.equals(tuple.getIsbn(), item.getIsbn())) {
                        tuple.setNum(tuple.getNum() + item.getBookAmount());
                        find = true;
                    }
                }
                if (!find) {
                    SelfLookup.Tuple tuple = selfLookup.new Tuple();
                    tuple.setIsbn(item.getIsbn());
                    tuple.setNum(item.getBookAmount());
                    tuple.setBookName("unset");
                    bookInfo.add(tuple);
                }
            }
        }
        for (SelfLookup.Tuple tuple: bookInfo) {
            Book book = bookDao.findBookByISBN(tuple.getIsbn());
            if (book == null) {
                tuple.setBookName("deleted book");
            } else tuple.setBookName(book.getName());
        }
        selfLookup.setBookInfo(bookInfo);
        result.setDetail(selfLookup);
        result.setMsg("ok");
        result.setCode(Constants.SUCCESS);
        return result;
    }
}
