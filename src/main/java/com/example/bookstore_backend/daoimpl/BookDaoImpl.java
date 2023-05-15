package com.example.bookstore_backend.daoimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Book findBookByISBN(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Integer deleteBookByISBN(String isbn) {
        return null;
    }

    @Override
    public Integer updateBook(Book book) {
        return null;
    }

    @Override
    public Integer addBook(Book book) {
        return null;
    }
}