package com.example.bookstore_backend.dao;

import com.example.bookstore_backend.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    List<Book> getBooksPage(String keyword, Pageable pageable);
    Book findBookByISBN(String isbn);
    Book findBookByName(String name);
    List<Book> searchBook(String keyword);

    void updateBook(Integer id, String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description);

    void deleteBook(Integer id);

    Book addBook(String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description);
}