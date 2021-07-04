package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.entity.Order;

import java.util.List;

public interface OrderService {
    Order NewOrder(int userID, double totprice);
    List<Order> FindAllByUserId(int userId);
    boolean Insert(int orderID, int userID, int bookID);
    List<Book> FindByOrderID(int orderID);
}
