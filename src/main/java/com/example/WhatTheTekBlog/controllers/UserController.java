package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.AppUser;
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
    public ResponseEntity<Iterable<AppUser>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<AppUser> findById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<AppUser> findByName(@PathVariable String userName) {
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
    public ResponseEntity<AppUser> create(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return new ResponseEntity<>(userService.create(appUser), HttpStatus.CREATED);
    }

    @PutMapping("/id/{userId}")
    public ResponseEntity<AppUser> update(@PathVariable int userId, @RequestBody AppUser appUser) {
        return new ResponseEntity<>(userService.update(userId, appUser), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable int userId) {
        return new ResponseEntity<>(userService.delete(userId), HttpStatus.OK);
    }

}
