package com.bookstore.controller;

import com.bookstore.entity.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin
    public User Login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.Login(username, password);
    }

    @PostMapping("/register")
    public boolean Register(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("email") String email) {
        return userService.Register(username, password, email);
    }

    @GetMapping("/findByUsername")
    public boolean FindByUsername(String username) {
        return userService.FindByUsername(username);
    }

    @PutMapping("/userForbidden")
    public boolean Forbidden(int userID, boolean act) {
        return userService.Forbidden(userID, act);
    }

    @GetMapping("/userList")
    public List<User> UserList() {
        return userService.UserList();
    }
}
