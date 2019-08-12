package com.danny.mongodb.controller;

import com.danny.mongodb.model.Book;
import com.danny.mongodb.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public String addBook(@RequestBody Book book) {
//        book.set_id((ObjectId.get()));
        Book savedBook = repository.save(book);
        return "Added book with id " + savedBook.getId();
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping()
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
//        return repository.findBy_id(id);
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable String id) {
        repository.delete(repository.findById(id).get());
        return "Deleted book by id " + id;
    }

}
