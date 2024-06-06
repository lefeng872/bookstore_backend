package com.example.bookstore_backend.entity;

import java.math.BigDecimal;

public class Consumer {
    private String username;
    private BigDecimal total;

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getUsername() {
        return username;
    }
}
