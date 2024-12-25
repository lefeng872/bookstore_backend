package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Consumer;
import com.example.bookstore_backend.entity.SelfLookup;
import com.example.bookstore_backend.entity.TypeCount;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.service.ClockService;
import com.example.bookstore_backend.service.UserService;
import com.example.bookstore_backend.utility.Result;
import com.example.bookstore_backend.utility.Constants;

import com.example.bookstore_backend.utility.SessionUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClockService clockService;
    @GetMapping(value = "test")
    public String test() {
        return "test alright";
    }

    @PostMapping(value = "/login")
    public Result<User> login(@RequestBody Map<String, String> params, HttpServletRequest request, HttpServletResponse response) {
        Result<User> result = userService.login(params.get("username"), params.get("password"));
        if (result != null && result.getCode() == Constants.SUCCESS) {
            result.setMsg("Login time is : " + clockService.start());
            SessionUtils.setSession(result.getDetail());
            return result;
        }
        return result;
    }
    @PostMapping(value = "/logout")
    public Result<String> logout(@RequestBody Map<String, String> params){
        System.out.println("in logout!!!");
        Result<String> result = new Result<>();
        result.setDetail(clockService.end());
        SessionUtils.removeSession();
        return result;
    }
    @PostMapping(value = "/register")
    public Result<User> register(@RequestBody Map<String, String> params) {
        System.out.println("in login");
        String username = params.get("username");
        String password = params.get("password");
        String email = params.get("email");
        return userService.register(username, password, email);
    }
    @GetMapping("/getUsers")
    public Result<List<User>> getUsers() {
        return userService.getUsers();
    }
    @PostMapping("/blockUser")
    public Result<List<User>> blockUser(@RequestBody Map<String, Integer> params) {
        Integer userID = params.get("userID");
        return userService.blockUser(userID);
    }
    @PostMapping("/unblockUser")
    public Result<List<User>> unblockUser(@RequestBody Map<String, Integer> params) {
        Integer userID = params.get("userID");
        return userService.unblockUser(userID);
    }

    @PostMapping("/userStatistic")
    public Result<List<Consumer>> userStatistic(@RequestBody Map<String, String> params) {
        String startString = params.get("start");
        String endString = params.get("end");
        Date startDate = null;
        Date endDate = null;
        try {
            // 将ISO 8601格式的日期时间字符串解析为Date对象
            startDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(startString);
            endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(endString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startDate != null && endDate != null) {
            Timestamp start = new Timestamp(startDate.getTime());
            Timestamp end = new Timestamp(endDate.getTime());
            System.out.println(start);
            System.out.println(end);
            return userService.userStatistic(start, end);
        }
        return null;
    }

    @PostMapping("/selfLookup")
    public Result<SelfLookup> selfLookup(@RequestBody Map<String, String> params) {
        Integer userID = Integer.parseInt(params.get("userID"));
        String startString = params.get("start");
        String endString = params.get("end");
        Date startDate = null;
        Date endDate = null;
        try {
            // 将ISO 8601格式的日期时间字符串解析为Date对象
            startDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(startString);
            endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(endString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startDate != null && endDate != null) {
            Timestamp start = new Timestamp(startDate.getTime());
            Timestamp end = new Timestamp(endDate.getTime());
            System.out.println(start);
            System.out.println(end);
            return userService.selfLookup(userID, start, end);
        }
        return null;
    }
}
