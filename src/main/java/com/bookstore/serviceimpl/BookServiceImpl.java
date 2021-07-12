package com.bookstore.serviceimpl;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookinOrder;
import com.bookstore.entity.Cart;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookinOrderRepository;
import com.bookstore.repository.CartRepository;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookinOrderRepository bookinOrderRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book ModifyBook(int ID, String image, String title, String author, double price, int inventory, int isbn) {
        Book originBook = bookRepository.findById(ID).get();
        originBook.setImage(image);
        originBook.setInventory(inventory);
        originBook.setAuthor(author);
        originBook.setIsbn(isbn);
        originBook.setPrice(price);
        originBook.setTitle(title);
        bookRepository.save(originBook);
        return originBook;
    }

    @Override
    public boolean DeleteBook(int id) {
        Book book = bookRepository.findById(id).get();
        List<BookinOrder> li_ = bookinOrderRepository.findByBookId(id);
        List<Cart> li = cartRepository.findByBookId(id);
        for (int i = 0; i < li.size(); i++) {
            cartRepository.deleteById(li.get(i).getID());
        }
        for (int i = 0; i < li_.size(); i++) {
            bookinOrderRepository.deleteById(li_.get(i).getId());
        }
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public Book AddBook(String image, String title, String author, double price, int inventory, int isbn) {
        Book originBook = new Book();
        originBook.setImage(image);
        originBook.setInventory(inventory);
        originBook.setAuthor(author);
        originBook.setIsbn(isbn);
        originBook.setPrice(price);
        originBook.setTitle(title);
        bookRepository.save(originBook);
        return originBook;
    }

}
