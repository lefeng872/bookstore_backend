package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/getBook")
    public Book getBook(String isbn){
        return bookService.findBookByISBN(isbn);
    }
}
