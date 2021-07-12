package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.entity.Order;
import com.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/insertOrder")
    public boolean Insert(int orderID, int userID, int bookID) {
        return orderService.Insert(orderID, userID, bookID);
    }

    @GetMapping("/orderDetail")
    public List<Book> FindByOrderID(int orderID) {
        return orderService.FindByOrderID(orderID);
    }

    @PostMapping("/newOrder")
    public Order NewOrder(int userID, double totprice) {
        return orderService.NewOrder(userID, totprice);
    }

    @GetMapping("/orderList")
    public List<Order> FindAllByUserId(int userID) {
        return orderService.FindAllByUserId(userID);
    }

    @GetMapping("/allOrderList")
    public List<Order> FindAll() {
        return orderService.FindAll();
    }
}
