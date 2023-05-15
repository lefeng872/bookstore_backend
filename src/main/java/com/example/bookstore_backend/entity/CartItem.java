package com.example.bookstore_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartItem")
public class CartItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cartItemID", nullable = false)
    private int cartItemID;
    @Basic
    @Column(name = "bookAmount", nullable = false)
    private int bookAmount;

    @Basic
    @Column(name = "isbn", nullable = false, length = 255)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartID")
    private Cart cart = new Cart();

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
