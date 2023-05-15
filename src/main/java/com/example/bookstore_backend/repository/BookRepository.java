package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    @Query("from Book")
    List<Book> getBooks();

    Book findBookByIsbn(String isbn);

}