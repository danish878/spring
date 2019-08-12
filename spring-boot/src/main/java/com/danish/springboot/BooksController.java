package com.danish.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        Book book = new Book(1, "Mastering Spring", "Danish");
        return Arrays.asList(book);
    }
}
