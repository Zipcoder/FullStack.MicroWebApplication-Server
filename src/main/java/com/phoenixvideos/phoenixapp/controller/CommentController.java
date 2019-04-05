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

    @GetMapping("/comment/{id}")
    public ResponseEntity<Set<Comment>> show(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/comment/{id}")
    public ResponseEntity<Video> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/comment/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteComment(@PathVariable Long id) {

    }
}
