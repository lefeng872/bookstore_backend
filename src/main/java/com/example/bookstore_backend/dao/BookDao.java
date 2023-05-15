package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    Book findBookByISBN(String isbn);
    Integer deleteBookByISBN(String isbn);
    Integer updateBook(Book book);
    Integer addBook(Book book);
}