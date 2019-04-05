package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class UserController {

    @PostMapping("/user/")
    public ResponseEntity<User> createUser(@RequestBody Long id) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser() {
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/user/video/{id}")
    public ResponseEntity<Video> createVideo(@PathVariable int id, @RequestBody Video video) {
        return new ResponseEntity<>( HttpStatus.CREATED);
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
