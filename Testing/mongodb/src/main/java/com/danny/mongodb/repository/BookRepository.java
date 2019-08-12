package com.danny.mongodb.repository;

import com.danny.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

//    Book findBy_id(ObjectId _id);
}
