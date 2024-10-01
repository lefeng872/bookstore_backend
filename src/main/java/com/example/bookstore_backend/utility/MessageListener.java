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
    private WebSocketServer ws;
    @Autowired
    OrderService orderService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "todo", groupId = "todo_group")
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
        } else {
            long time = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String failTime = simpleDateFormat.format(new Date(time));
            kafkaTemplate.send("failed", key, record.value() + "," + failTime);
        }
    }

    @KafkaListener(topics = "finished", groupId = "finished_group")
    public void finishedListener(ConsumerRecord<String, String> record) {
        String createTime = record.key();
        String[] value = record.value().split(",");
        System.out.println("finished listener get: (createTime: " + createTime + ", finishTime: " + value[1] + ", userID: " + value[0] + ")");
        ws.sendMessageToUser(Integer.valueOf(value[0]), "Success! The order you made at " + createTime + " is finished at " + value[1]);
    }

    @KafkaListener(topics = "failed", groupId = "failed_group")
    public void failedListener(ConsumerRecord<String, String> record) {
        String createTime = record.key();
        String[] value = record.value().split(",");
        System.out.println("failed listener get: (createTime: " + createTime + ", finishTime: " + value[1] + ", userID: " + value[0] + ")");
        ws.sendMessageToUser(Integer.valueOf(value[0]), "Failed! The order you made at " + createTime + " is failed at " + value[1]);
    }
}
