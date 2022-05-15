package com.example.ui.controller;

import com.example.ui.domain.Book;
import com.example.ui.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @GetMapping("/")
    public Iterable<Book> findBooks() {
        return bookService.allBooks();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody final Book book) {
        return this.bookService.postBook(book);
    }
}
