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
    public ResponseEntity<User> create(@RequestBody Long id) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> show() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/user/video/{id}")
    public ResponseEntity<Video> createVideo(@PathVariable int id, @RequestBody Video video) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/user/video/upload/{id}/{video_id}")
    public ResponseEntity<Video> uploadVideo(@PathVariable int id, @PathVariable int video_id,
                                             @RequestBody File video) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}
