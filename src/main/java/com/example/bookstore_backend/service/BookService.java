package com.example.bookstore_backend.service;

import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.utility.Result;

import java.util.List;

public interface BookService {
    public Result<Book> findBookByISBN(String isbn);
    public Result<List<Book>> getBooks();
    public Result<List<Book>> getBooksPage(String keyword, Integer pageIndex, Integer pageSize);
    public Result<Book> findBookByName(String name);
    public Result<List<Book>> searchBook(String keyword);
    public Result<List<Book>> updateBook(Integer id, String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description);
    Result<List<Book>> deleteBook(Integer id);
    Result<List<Book>> addBook(String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description);
}