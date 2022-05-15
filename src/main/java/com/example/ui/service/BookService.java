package com.example.ui.service;

import com.example.ui.domain.Book;
import com.example.ui.exception.BookNotFoundException;
import com.example.ui.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(String id) {
        return this.repository.findById(id)
         .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " is not found."));
    }

    public Iterable<Book> allBooks() {
        return this.repository.findAll();
    }

    public Book postBook(Book book) {
        return this.repository.save(book);
    }
}
