package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CommentController {


    @PostMapping("/video/comments/{id}")
    public ResponseEntity<Comment> create(@RequestBody User user) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/video/comments/all")
    public ResponseEntity<Comment> show() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<Set<Comment>> show(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
    @PutMapping("/video/{id}")
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/video/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteEmployee(@PathVariable Long id) {

    }
}
