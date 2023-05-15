package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Book;

import java.util.List;

public interface BookService {
    Book findBookByISBN(String isbn);
    List<Book> getBooks();
}