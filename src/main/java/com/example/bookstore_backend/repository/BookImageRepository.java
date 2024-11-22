package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.BookImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookImageRepository extends MongoRepository<BookImage, String> {
    BookImage findBookImageById(int id);
    List<BookImage> findAll();
    void deleteBookImageById(int id);
}
