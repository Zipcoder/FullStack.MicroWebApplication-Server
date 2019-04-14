package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<User> findById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<User> findByName(@PathVariable String userName) {
        return new ResponseEntity<>(userService.findByName(userName), HttpStatus.OK);
    }

    @GetMapping("/posts/{userId}")
    public ResponseEntity<Iterable<Post>> getPostsByUser(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getPostsByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/comments/{userId}")
    public ResponseEntity<Iterable<Comments>> getCommentsByUser(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getCommentsByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> create(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/id/{userId}")
    public ResponseEntity<User> update(@PathVariable int userId, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(userId, user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable int userId) {
        return new ResponseEntity<>(userService.delete(userId), HttpStatus.OK);
    }

}
