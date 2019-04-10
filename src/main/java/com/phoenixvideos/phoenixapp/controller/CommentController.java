package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;

import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.service.CommentService;
import com.phoenixvideos.phoenixapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CommentController {


    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

//    @PostMapping("/videos/comment/")
//    public ResponseEntity<Comment> createComment(@PathVariable Long id, @RequestBody Comment comment) {
////step 1
//
//        return new ResponseEntity<>(commentService.create(comment),HttpStatus.CREATED);
//    }

    @GetMapping("videos/comment/{id}")
    public ResponseEntity<Set<Comment>> show(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("videos/comment/{id}")
    public ResponseEntity<Video> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("videos/comment/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteComment(@PathVariable Long id) {
    }
}