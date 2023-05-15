package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book findBookByISBN(String isbn) {
        return bookDao.findBookByISBN(isbn);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}