package com.bookstore.serviceimpl;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartRepository;
import com.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public boolean AddToCart(int bookID, int userID) {
        Cart cart = new Cart();
        System.out.print(bookID);
        System.out.println(userID);
        cart.setBookID(bookID);
        cart.setUserID(userID);
        cartRepository.save(cart);
        return true;
    }

    @Override
    public boolean DeleteById(int id) {
        System.out.println(id);
        cartRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Cart> cartlist(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public boolean ClearCart(int userID) {
        List<Cart> li = cartlist(userID);
        for (int i = 0; i < li.size(); i++) {
            int bookID = li.get(i).getBookID();
            int cartID = li.get(i).getID();
            System.out.print("bookID: ");
            System.out.println(bookID);
            Book book = bookRepository.findById(bookID).get();
            book.setInventory(book.getInventory()-1);
            bookRepository.save(book);
            cartRepository.deleteById(cartID);
        }
        return true;
    }
}
