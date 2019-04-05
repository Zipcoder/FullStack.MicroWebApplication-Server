package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.entities.Post;
import com.example.WhatTheTekBlog.services.PostService;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
@RequestMapping
public class PostController {

  private final Logger LOG = LoggerFactory.getLogger(PostController.class);

  @Autowired
  private PostService postService;

  public PostController(PostService service) {
    this.postService = service;
  }

  @GetMapping("/post/")
  public ResponseEntity<Iterable<Post>> findAll() {
    return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/post/{postId}")
  public ResponseEntity<Optional<Post>> findByPostId(@PathVariable Long postId) {
    if (postService.findByPostId(postId) != null) {
      return new ResponseEntity<>(postService.findByPostId(postId), HttpStatus.OK);
    } else {
      LOG.info("Post not found with ID: {}", postId);
      return new ResponseEntity<>(postService.findByPostId(postId), HttpStatus.NOT_FOUND);
    }

  }

  @PostMapping("/post/")
  public ResponseEntity<Post> create(@RequestBody Post post) {
    LOG.info("Creating a new Post: {}", post);
    return new ResponseEntity<>(this.postService.createPost(post), HttpStatus.CREATED);
  }

  @PutMapping("/post/{postId}")
  public ResponseEntity<Post> update(@PathVariable Long postId, @RequestBody Post post) {
    Optional<Post> currentPost = this.postService.findByPostId(postId);

    if(currentPost == null){
      LOG.info("Unable to update, Post not found with Id: {}",postId);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    LOG.info("Updating Post: {}", postId);
    return new ResponseEntity<>(this.postService.updatePost(postId,post), HttpStatus.OK);
  }

  @DeleteMapping("/post/{postId}")
  public ResponseEntity<Boolean> delete(@PathVariable Long postId, @RequestBody Post post){
    LOG.info("Deleting Post: {}", post);
    return new ResponseEntity<>(this.postService.delete(postId),HttpStatus.OK);
  }

}
