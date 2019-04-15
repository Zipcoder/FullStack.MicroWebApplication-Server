package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.services.CommentsService;
import com.example.WhatTheTekBlog.services.TagsService;
import com.example.WhatTheTekBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
public class CommentsController {
    
//ResourceNotFoundExcepion

    private CommentsService commentsService;
    private UserService userService;


    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/comment")
    public ResponseEntity<Comments> createComments(@RequestBody Comments comments) {
        //comments.setAppUser(userService.findByName());
        return new ResponseEntity<>(commentsService.create(comments), HttpStatus.CREATED);
    }

    //Only 2 get mappings at a time otherwise I will get 500 error if I run all three
    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comments>> findAll() {
        return new ResponseEntity<>(this.commentsService.findAllComments(), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Optional<Comments>> getCommentById(@PathVariable("id") Long id){

        return new ResponseEntity<>(this.commentsService.findCommentById(id), HttpStatus.OK);
    }

    @GetMapping("/comments_post/{post_id}")
    public ResponseEntity<List<Comments>> getCommentsByPostId(@PathVariable("post_id") Long post_id){

    return new ResponseEntity<>(this.commentsService.findAllCommentByPost(post_id), HttpStatus.OK);

    }


    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> updateComments(@PathVariable("id") Long id,@RequestBody Comments comments) {
        return new ResponseEntity<>(this.commentsService.updateComments(id, comments), HttpStatus.OK);
    }


    @DeleteMapping("/comments/{comment}")
    public ResponseEntity<Boolean> deleteComments(@PathVariable String comment) {
        return new ResponseEntity<>(this.commentsService.delete(comment), HttpStatus.OK);
    }


}
