package com.vethishan.controller;

import com.vethishan.exception.UserException;
import com.vethishan.modal.User;
import com.vethishan.repository.UserRepository;
import com.vethishan.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUser(){
        List<User> users= userRepository.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserException{
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws UserException {
        User updateduser= userService.updateUser(id,user);
        return new ResponseEntity<>(updateduser,HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws UserException {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
    }
}
