package com.example.bookstore_backend.daoimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book findBookByISBN(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }
    @Override
    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    @Override
    public List<Book> searchBook(String keyword) {
        return bookRepository.searchBooksByKeyword(keyword);
    }

    @Override
    public void updateBook(Integer id, String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            System.out.println("update book don't exist!");
            return;
        } else {
            book.setName(name);
            book.setAuthor(author);
            book.setImage(image);
            book.setIsbn(isbn);
            book.setInventory(inventory);
            book.setType(type);
            book.setPrice(BigDecimal.valueOf(price));
            book.setDescription(description);
            bookRepository.save(book);
            System.out.println("update finished~");
        }
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public Book addBook(String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setImage(image);
        book.setIsbn(isbn);
        book.setInventory(inventory);
        book.setType(type);
        book.setPrice(BigDecimal.valueOf(price));
        book.setDescription(description);
        book = bookRepository.save(book);
        return book;
    }
}