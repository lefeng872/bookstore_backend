package com.example.bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler","user"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "orderID")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderID", nullable = false)
    private int orderID;
    @Column(name = "dateTime", nullable = false)
    private Timestamp timestamp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID")
    private User user;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal total() {
        BigDecimal total = BigDecimal.valueOf(0.0);
        for (OrderItem item: orderItems) {
            System.out.println(item.getCurrentPrice().multiply(BigDecimal.valueOf(item.getBookAmount())));
            total = total.add(item.getCurrentPrice().multiply(BigDecimal.valueOf(item.getBookAmount())));
            System.out.println("added total");
            System.out.println(total);
        }
        System.out.println("total of this order");
        System.out.println(total);
        return total;
    }
}
