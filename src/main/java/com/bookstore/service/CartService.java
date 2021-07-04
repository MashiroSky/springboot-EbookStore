package com.bookstore.service;

import com.bookstore.entity.Cart;

import java.util.List;

public interface CartService {
    boolean AddToCart(int bookID, int userId);
    boolean DeleteById(int id);

    List<Cart> cartlist(int userId);

    boolean ClearCart(int userID);
}
