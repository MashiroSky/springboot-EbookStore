package com.bookstore.service;

import com.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(int id);
    List<Book> findByTitle(String title);

    Book ModifyBook(int ID, String image, String title, String author, double price, int inventory, int isbn);

    boolean DeleteBook(int id);

    Book AddBook(String image, String title, String author, double price, int inventory, int isbn);
}
