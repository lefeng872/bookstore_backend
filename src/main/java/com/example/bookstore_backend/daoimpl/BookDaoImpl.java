package com.example.bookstore_backend.daoimpl;

import com.alibaba.fastjson.JSON;
import com.example.bookstore_backend.dao.BookDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.entity.BookImage;
import com.example.bookstore_backend.repository.BookImageRepository;
import com.example.bookstore_backend.repository.BookRepository;

import com.example.bookstore_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookImageRepository bookImageRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return fillImage(books);
    }

    @Override
    public List<Book> getBooksPage(String keyword, Pageable pageable) {
//
//        return bookRepository.findAll(pageable).getContent();
//
        return fillImage(bookRepository.findByNameContaining(keyword, pageable).getContent());
    }

    private List<Book> fillImage(List<Book> books) {
        List<BookImage> bookImages = bookImageRepository.findAll();
        for (Book book : books) {
            for (BookImage bookImage : bookImages) {
                if (bookImage.getId() == book.getId()) {
                    book.setImage(bookImage.getImage());
                }
            }
        }
        return books;
    }

    @Override
    public Book findBookByISBN(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);
        book.setImage(bookImageRepository.findBookImageById(book.getId()).getImage());
        return book;
    }

    @Override
    public Book findBookByName(String name) {
        Book book = bookRepository.findBookByName(name);
        book.setImage(bookImageRepository.findBookImageById(book.getId()).getImage());
        return book;
    }

    @Override
    public Book findBookById(int id) {
        Book book = null;
        try {
            // 尝试从 Redis 获取数据
            String b = (String) redisTemplate.opsForValue().get("book" + id);
            if (b == null) {
                System.out.println("book" + id + " is in db");
                // 如果 Redis 中没有该书，则从数据库中获取
                book = bookRepository.findBookById(id);
                book.setImage(bookImageRepository.findBookImageById(book.getId()).getImage());
                // 将结果写入 Redis
                redisTemplate.opsForValue().set("book" + id, JSON.toJSONString(book));
            } else {
                System.out.println("book" + id + " is in redis");
                // 如果 Redis 中有该书，则解析并返回
                book = JSON.parseObject(b, Book.class);
            }
        } catch (Exception e) {
            // 捕获 Redis 操作的异常，确保 Redis 出现问题时不影响数据库查询
            System.out.println("Redis 服务器连接失败或其他错误，直接从数据库中获取数据: " + e.getMessage());
            book = bookRepository.findBookById(id);  // 直接从数据库中查询
            book.setImage(bookImageRepository.findBookImageById(book.getId()).getImage());
        }
        return book;
    }


    @Override
    public List<Book> searchBook(String keyword) {
        return fillImage(bookRepository.searchBooksByKeyword(keyword));
    }

    // todo redis
    @Override
    public void updateBook(Integer id, String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        Book book = bookRepository.findBookById(id);
        BookImage bookImage = bookImageRepository.findBookImageById(id);
        if (book == null || bookImage == null) {
            System.out.println("update book don't exist!");
            return;
        } else {
            book.setName(name);
            book.setAuthor(author);
//            book.setImage(image);
            book.setIsbn(isbn);
            book.setInventory(inventory);
            book.setType(type);
            book.setPrice(BigDecimal.valueOf(price));
            book.setDescription(description);
            try {
                Object b = redisTemplate.opsForValue().get("book" + id);
                if (b != null) {
                    System.out.println("update book" + id + " in redis");
                    redisTemplate.opsForValue().set("book" + id, JSON.toJSONString(book));
                }
            } catch (Exception e) {
                System.out.println("Redis 服务器连接失败或其他错误" + e.getMessage());
            }
            System.out.println("update book" + id + " in db");
            bookRepository.save(book);
            System.out.println("mysql update finished~");
            bookImage.setImage(image);
            bookImageRepository.save(bookImage);
            System.out.println("mongodb update finished~");
        }
    }

    // todo redis
    @Override
    public void deleteBook(Integer id) {
        try {
            redisTemplate.delete("book" + id);
            System.out.println("delete book" + id + " in redis");
        } catch (Exception e) {
            System.out.println("Redis 服务器连接失败或其他错误" + e.getMessage());
        }
        System.out.println("delete book" + id + " in db");
        bookRepository.deleteBookById(id);
        bookImageRepository.deleteBookImageById(id);
    }

    // todo redis
    @Override
    public Book addBook(String name, String author, String image, String isbn, Integer inventory, String type, Float price, String description) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
//        book.setImage(image);
        book.setIsbn(isbn);
        book.setInventory(inventory);
        book.setType(type);
        book.setPrice(BigDecimal.valueOf(price));
        book.setDescription(description);
        System.out.println("add book in db");
        book = bookRepository.save(book);
        BookImage bookImage = new BookImage(book.getId(), image);
        bookImageRepository.save(bookImage);
        try {
            redisTemplate.opsForValue().set("book" + book.getId(), JSON.toJSONString(book));
            System.out.println("add book" + book.getId() + " in redis");
        } catch (Exception e) {
            System.out.println("Redis 服务器连接失败或其他错误" + e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> searchType(String type) {
        List<String> types = categoryRepository.findRelatedCategories(type);
        types.add(type);
        List<Book> books = new ArrayList<>();
        for (String category : types) {
            books.addAll(bookRepository.findBookByType(category));
        }
        return books;
    }
}