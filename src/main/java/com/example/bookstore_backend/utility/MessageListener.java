package com.example.bookstore_backend.utility;

import com.example.bookstore_backend.service.OrderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableAutoConfiguration
public class MessageListener {
    @Autowired
    OrderService orderService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "todo", groupId = "default_group")
    public void todoListener(ConsumerRecord<String, String> record) {
        String key = record.key();
        int userID = Integer.parseInt(record.value());
        System.out.println("todo listener get: (key: " + key + ", userID: " + userID + ")");
        boolean result = orderService.makeOrder(userID);
        if (result) {
            long time = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String finishTime = simpleDateFormat.format(new Date(time));
            kafkaTemplate.send("finished", key, record.value() + "," + finishTime);
        }
    }
}
