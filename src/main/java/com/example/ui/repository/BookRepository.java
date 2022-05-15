package com.example.ui.repository;

import com.example.ui.domain.Book;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {

}
