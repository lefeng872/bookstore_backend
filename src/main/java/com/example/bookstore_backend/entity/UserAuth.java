package com.example.bookstore_backend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserAuth {
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private User user;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "authID", nullable = false)
    private int authId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

}
