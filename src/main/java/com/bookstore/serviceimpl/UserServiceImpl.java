package com.bookstore.serviceimpl;

import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User Login(String username, String password) {
        System.out.println(username + ' ' + password);
        User user = userRepository.checkUser(username, password);
        System.out.println(user);
        return user;
    }

    @Override
    public boolean Register(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUser_type(false);
        user.setForbidden(false);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean FindByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    @Override
    public boolean Forbidden(int userID, boolean act) {
        System.out.print(userID);
        System.out.println(act);
        User user = userRepository.findById(userID).orElse(null);
        user.setForbidden(act);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> UserList() {
        return userRepository.findAll();
    }
}
