package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/booklist")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @RequestMapping("/bookdetail")
    public Optional<Book> findById(int id) {
        return bookService.findById(id);
    }

    @GetMapping("/search")
    public List<Book> findByTitle(String title) {
        System.out.println("findByTitle: "+title);
        return bookService.findByTitle(title);
    }
}
