package com.developer.sumukh.lms.controller;

import com.developer.sumukh.lms.model.Book;
import com.developer.sumukh.lms.repository.BookRepository;
import com.developer.sumukh.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @GetMapping(value = "/getBooks")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping(value = "/searchBook")
    public List<Book> searchBook(@RequestParam String key) {
        return bookService.searchBook(key);
    }

}
