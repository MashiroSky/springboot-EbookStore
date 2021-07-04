package com.bookstore.controller;

import com.bookstore.entity.Cart;
import com.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("/addToCart")
    public boolean AddToCart(int bookID, int userID) {
        return cartService.AddToCart(bookID, userID);
    }
    @PostMapping("/deleteCartById")
    public boolean DeleteCartById(@RequestParam("id") int id) {
        return cartService.DeleteById(id);
    }

    @GetMapping("/cartlist")
    public List<Cart> cartlist(int userId) {
        return cartService.cartlist(userId);
    }

    @PostMapping("/clearCart")
    public boolean ClearCart(@RequestParam("userID") int userID) {
        return cartService.ClearCart(userID);
    }
}
