package com.bookstore.service;

import com.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(int id);
    List<Book> findByTitle(String title);
}
