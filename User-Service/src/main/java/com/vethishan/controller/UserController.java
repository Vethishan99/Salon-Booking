package com.vethishan.controller;

import com.vethishan.modal.User;
import com.vethishan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();
        user.setFullName("Vethishan");
        user.setEmail("vethishan@gmail.com");
        user.setPhone("123456789");
        user.setRole("CUSTOMER");
        return user;
    }
}
