package com.bookstore.service;

import com.bookstore.entity.User;

import java.util.List;

public interface UserService {
    User Login(String username, String password);
    boolean Register(String username, String password, String email);
    boolean FindByUsername(String username);

    boolean Forbidden(int userID, boolean act);

    List<User> UserList();
}
