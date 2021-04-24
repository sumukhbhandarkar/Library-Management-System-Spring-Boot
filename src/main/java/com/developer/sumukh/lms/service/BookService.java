package com.developer.sumukh.lms.service;

import com.developer.sumukh.lms.model.Book;
import com.developer.sumukh.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public String addBook(Book book) {
        if (book.getBookId() == 0 || bookRepository.findById(book.getBookId()).isPresent())
            return "Book already exists or book id is incorrect";
        bookRepository.save(book);
        return "Book added successfully";
    }

    public List<Book> searchBook(String key) {
        key = key.toLowerCase();
        ArrayList<Book> result = new ArrayList<>();
        List<Book> searchResult = bookRepository.findAll();
        for(Book book : searchResult) {
            if (book.getBookAuthor().toLowerCase().contains(key) ||
                    book.getBookGenre().toLowerCase().contains(key) ||
                    book.getBookTitle().toLowerCase().contains(key) ||
                    book.getBookTags().toLowerCase().contains(key))
                result.add(book);
        }
        if (result.size() == 0) {
            Book temp = new Book();
            temp.setBookTags("No books found for searched key");
            result.add(temp);
        }
        return result;
    }
}
