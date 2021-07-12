package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/modifyBook")
    public Book ModifyBook(int ID, String image, String title, String author, double price, int inventory, int isbn) {
        return bookService.ModifyBook(ID, image, title, author, price, inventory, isbn);
    }

    @PostMapping("/addBook")
    public Book AddBook(String image, String title, String author, double price, int inventory, int isbn) {
        return bookService.AddBook(image, title, author, price, inventory, isbn);
    }

    @PostMapping("/deleteBook")
    public boolean DeleteBook(int ID) {
        return bookService.DeleteBook(ID);
    }

}
