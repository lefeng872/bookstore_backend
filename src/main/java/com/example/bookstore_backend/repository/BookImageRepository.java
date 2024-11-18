package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.BookImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookImageRepository extends MongoRepository<BookImage, String> {
    BookImage findBookImageById(int id);
}
