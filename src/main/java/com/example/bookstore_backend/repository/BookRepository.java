package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findBookByIsbn(String isbn);
    List<Book> findAll();
    Book findBookById(Integer ID);
    Book findBookByName(String name);
    @Query("SELECT b FROM Book b WHERE b.name LIKE %:keyword%")
    List<Book> searchBooksByKeyword(String keyword);
    void deleteBookById(Integer id);
}