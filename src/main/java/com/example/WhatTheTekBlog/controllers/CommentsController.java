package com.example.WhatTheTekBlog.controllers;

import com.auth0.jwt.JWT;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.services.CommentsService;
import com.example.WhatTheTekBlog.services.PostService;
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
    private PostService postService;


    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/comment")

    public ResponseEntity<Comments> create(@RequestBody String token, Comments comments, Long postID) {
        String name = JWT.decode(token).getClaim("nickname").asString();
        if (userService.contains(name)) {
            User user = userService.findByName(name);
           Optional<Post> post = postService.findByPostId(postID);
           comments.setUser(user);
           //comments.setPost(post);
            return new ResponseEntity<>(commentsService.create(comments), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
    }
//    public ResponseEntity<Comments> createComments(@RequestBody Comments comments) {
//        //comments.setAppUser(userService.findByName());
//        return new ResponseEntity<>(commentsService.create(comments), HttpStatus.CREATED);
//    }

    //Only 2 get mappings at a time otherwise I will get 500 error if I run all three
    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comments>> findAll() {
        return new ResponseEntity<>(this.commentsService.findAllComments(), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Optional<Comments>> getCommentById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.commentsService.findCommentById(id), HttpStatus.OK);
    }

    @GetMapping("/comments_post/{post_id}")
    public ResponseEntity<List<Comments>> getCommentsByPostId(@PathVariable("post_id") Long post_id) {

        return new ResponseEntity<>(this.commentsService.findAllCommentByPost(post_id), HttpStatus.OK);

    }


    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> updateComments(@PathVariable("id") Long id, @RequestBody Comments comments) {
        return new ResponseEntity<>(this.commentsService.updateComments(id, comments), HttpStatus.OK);
    }


//    @DeleteMapping("/deleteComment/{comment}")
//    public ResponseEntity<Boolean> deleteComments(@PathVariable String comment) {
//        return new ResponseEntity<>(this.commentsService.delete(comment), HttpStatus.OK);
//    }

    @DeleteMapping("/deleteComment/{comment_id}")
    public ResponseEntity<Boolean> deleteComments(@PathVariable Long comment_id) {
        return new ResponseEntity<>(this.commentsService.delete(comment_id), HttpStatus.OK);
    }

}
