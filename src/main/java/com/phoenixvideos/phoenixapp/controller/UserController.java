package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.service.CommentService;
import com.phoenixvideos.phoenixapp.service.UserService;
import com.phoenixvideos.phoenixapp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class UserController {

    private UserService userService;
    private VideoService videoService;
    private CommentService commentService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user),HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.show(id),HttpStatus.OK);
    }

    @PostMapping("/user/video/{id}")
    public ResponseEntity<Video> createVideo(@PathVariable int id, @RequestBody Video video) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/user/video/upload/{userId}/{videoId}")
    public ResponseEntity<String> uploadVideo(@PathVariable Long userId, @PathVariable int videoId,
                                             @RequestBody File video) {
        return new ResponseEntity<>("A response message is returned", HttpStatus.CREATED);
    }
    @PostMapping("/user/comment/{id}")
    public ResponseEntity<Comment> create(@PathVariable Long id, @RequestBody Comment comment) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
