package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.*;
import com.example.bookstore_backend.repository.OrderRepository;
import com.example.bookstore_backend.service.OrderService;
import com.example.bookstore_backend.utility.Constants;
import com.example.bookstore_backend.utility.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping("/getOrders")
    public Result<List<Order>> getOrders(@RequestBody Map<String, Integer> params) {
        Integer userID = params.get("userID");
        return orderService.getOrders(userID);
    }
    @PostMapping("/searchOrders")
    public Result<List<Order>> searchOrders(@RequestBody Map<String, String> params) {
        Integer userID = Integer.valueOf(params.get("userID"));
        String keyword = params.get("keyword");
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
            return orderService.searchOrders(userID, keyword, start, end);
        }
        return null;
    }
    @PostMapping("/searchAllOrders")
    public Result<List<Order>> searchAllOrders(@RequestBody Map<String, String> params) {
        Integer userID = Integer.valueOf(params.get("userID"));
        String keyword = params.get("keyword");
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
            return orderService.searchAllOrders(userID, keyword, start, end);
        }
        return null;
    }
    @PostMapping("/makeOrder")
    public void makeOrder(@RequestBody Map<String, Integer> params) throws JsonProcessingException {
        // todo
        Integer userID = params.get("userID");
        orderService.makeOrder(userID);
    }
    @GetMapping("/getAllOrders")
    public Result<List<Order>> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping("/typeStatistic")
    public Result<List<TypeCount>> typeStatistic(@RequestBody Map<String, String> params) {
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
            return orderService.typeStatistic(start, end);
        } else {
            Result<List<TypeCount>> fail = new Result<>();
            fail.setCode(Constants.FAIL);
            fail.setMsg("miss time info");
            fail.setDetail(null);
            return fail;
        }
    }
}