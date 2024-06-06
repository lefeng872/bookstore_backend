package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.service.BookService;

import com.example.bookstore_backend.utility.Constants;
import com.example.bookstore_backend.utility.Result;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    private Result<Book> bookResult = new Result<>();
    private Result<List<Book>> listResult = new Result<>();
    @Override
    public Result<Book> findBookByISBN(String isbn) {
        Book book = bookDao.findBookByISBN(isbn);
        if (book == null) {
            bookResult.setCode(Constants.FAIL);
            bookResult.setMsg("Not found this book");
            bookResult.setDetail(null);
        } else {
            bookResult.setCode(Constants.SUCCESS);
            bookResult.setMsg("Found this book");
            bookResult.setDetail(book);
        }
        return bookResult;
    }
    @Override
    public Result<List<Book>> getBooks() {
        List<Book> books = bookDao.getBooks();
        if (books == null) {
            listResult.setCode(Constants.FAIL);
            listResult.setMsg("Empty database");
            listResult.setDetail(null);
        } else {
            listResult.setCode(Constants.SUCCESS);
            listResult.setMsg("Success to fetch");
            listResult.setDetail(books);
        }
        return listResult;
    }
    @Override
    public Result<Book> findBookByName(String name) {
        Book book = bookDao.findBookByName(name);
        if (book == null) {
            bookResult.setCode(Constants.FAIL);
            bookResult.setMsg("Not found this book");
            bookResult.setDetail(null);
        } else {
            bookResult.setCode(Constants.SUCCESS);
            bookResult.setMsg("Found this book");
            bookResult.setDetail(book);
        }
        return bookResult;
    }

    @Override
    public Result<List<Book>> searchBook(String keyword) {
        List<Book> books = bookDao.searchBook(keyword);
        if (books == null) {
            listResult.setCode(Constants.FAIL);
            listResult.setMsg("Empty database");
            listResult.setDetail(null);
        } else {
            listResult.setCode(Constants.SUCCESS);
            listResult.setMsg("Success to fetch");
            listResult.setDetail(books);
        }
        return listResult;
    }

    @Override
    public Result<List<Book>> updateBook(Integer id, String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        bookDao.updateBook(id, name, author, image, isbn, inventory, type, price, description);
        List<Book> books = bookDao.getBooks();
        listResult.setCode(Constants.SUCCESS);
        listResult.setMsg("update ok");
        listResult.setDetail(books);
        return listResult;
    }

    @Override
    public Result<List<Book>> deleteBook(Integer id) {
        bookDao.deleteBook(id);
        List<Book> books = bookDao.getBooks();
        listResult.setCode(Constants.SUCCESS);
        listResult.setMsg("delete ok");
        listResult.setDetail(books);
        return listResult;
    }

    @Override
    public Result<List<Book>> addBook(String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        Book book = bookDao.addBook(name, author, image, isbn, inventory, type, price, description);
        if (book == null) {
            listResult.setMsg("add fail");
        } else {
            listResult.setMsg("add ok");
        }
        List<Book> books = bookDao.getBooks();
        listResult.setCode(Constants.SUCCESS);
        listResult.setDetail(books);
        return listResult;
    }
}