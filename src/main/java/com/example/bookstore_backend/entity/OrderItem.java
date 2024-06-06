package com.example.bookstore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderItem")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler", "order"})
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderItemID", nullable = false)
    private int orderItemID;
    @Basic
    @Column(name = "bookAmount", nullable = false)
    private int bookAmount;
    @Basic
    @Column(name = "isbn", nullable = false, length = 255)
    private String isbn;
    @Basic
    @Column(name = "currentPrice", nullable = false)
    private BigDecimal currentPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderID")
    private Order order = new Order();
    public int getOrderItemID() {
        return orderItemID;
    }
    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }
    public int getBookAmount() {
        return bookAmount;
    }
    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
