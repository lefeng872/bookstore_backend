package com.example.bookstore_backend.controller;

import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.service.BookService;

import com.example.bookstore_backend.utility.Constants;
import com.example.bookstore_backend.utility.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@EnableAutoConfiguration
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/getBooks")
    public Result<List<Book>> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/getBookPage")
    public Result<List<Book>> getBookPage(@RequestParam String keyword, @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        if (pageIndex == null || pageIndex < 0 || pageSize == null || pageSize < 0) {
            Result<List<Book>> empty = new Result<>();
            empty.setCode(Constants.FAIL);
            empty.setDetail(null);
            empty.setMsg("illegal arguments");
            return empty;
        }
        return bookService.getBooksPage(keyword, pageIndex, pageSize);
    }
    @GetMapping("/getBook")
    public Result<Book> getBook(String isbn){
        return bookService.findBookByISBN(isbn);
    }
    @GetMapping("/searchBook")
    public Result<List<Book>> searchBook(String keyword) {
        System.out.println(keyword);
        if (keyword == "") {
            return bookService.getBooks();
        } else {
            return bookService.searchBook(keyword);
        }
    }
    @PostMapping("/updateBook")
    public Result<List<Book>> updateBook(@RequestBody Map<String, String> params) {
        System.out.println("in update book");
        Integer id = Integer.parseInt(params.get("id"));
        String name = params.get("name");
        String author = params.get("author");
        String image = params.get("image");
        String isbn = params.get("isbn");
        Integer inventory = Integer.parseInt(params.get("inventory"));
        String type = params.get("type");
        Float price = Float.parseFloat(params.get("price"));
        String description = params.get("description");
        System.out.println("all params get");
        return bookService.updateBook(id, name, author, image, isbn, inventory, type, price, description);
    }

    @GetMapping("/deleteBook")
    @Transactional
    public Result<List<Book>> deleteBook(Integer id) {
        return bookService.deleteBook(id);
    }

    @PostMapping("/addBook")
    public Result<List<Book>> addBook(@RequestBody Map<String, String> params) {
        System.out.println("in add book");
        String name = params.get("name");
        String author = params.get("author");
        String image = params.get("image");
        String isbn = params.get("isbn");
        Integer inventory = Integer.parseInt(params.get("inventory"));
        String type = params.get("type");
        Float price = Float.parseFloat(params.get("price"));
        String description = params.get("description");
        System.out.println("all params get");
        return bookService.addBook(name, author, image, isbn, inventory, type, price, description);
    }
}
