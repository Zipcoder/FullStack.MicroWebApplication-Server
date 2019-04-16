package com.example.WhatTheTekBlog.controllers;

import com.auth0.jwt.JWT;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.services.PostService;
import com.example.WhatTheTekBlog.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping
public class PostController {

  private final Logger LOG = LoggerFactory.getLogger(PostController.class);

  private PostService postService;
  private UserService userService;

  @Autowired
  public PostController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("/post/")
  public ResponseEntity<Iterable<Post>> findAll() {
    return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/post/{pageNum}&{pageSize}")
  public ResponseEntity<Page> findAllByPage(@PathVariable int pageNum, @PathVariable int pageSize){
    Page page = postService.findAllByPages(PageRequest.of(pageNum,pageSize));
    return new ResponseEntity<>(page,HttpStatus.OK);
  }


  @GetMapping("/post/{postId}")
  public ResponseEntity<?> getPost(@PathVariable Long postId) {
    Optional<Post> post = postService.findByPostId(postId);
    return post.map(response -> ResponseEntity.ok().body(response))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/users/createPost/{token}")
  public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable String token){
    String name = JWT.decode(token).getClaim("nickname").asString();
    User user = userService.findByName(name);
    post.setCreator(user);
    user.addPost(post);
    userService.update(user.getId(), user);
    LOG.info("Creating a new Post: {}", post);
    return new ResponseEntity<>(this.postService.createPost(post), HttpStatus.CREATED);
  }

  @PutMapping("/users/updatePost/{postId}")
  public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post post) {
    Optional<Post> currentPost = this.postService.findByPostId(postId);

    if(!currentPost.isPresent()){
      LOG.info("Unable to update, Post not found with Id: {}",postId);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    LOG.info("Updating Post: {}", postId);
    return new ResponseEntity<>(this.postService.updatePost(postId,post), HttpStatus.OK);
  }

  @DeleteMapping("/users/deletePost/{postId}")
  public ResponseEntity<Boolean> deletePost(@PathVariable Long postId, @RequestBody Post post){
    LOG.info("Deleting Post: {}", post);
    return new ResponseEntity<>(this.postService.delete(postId),HttpStatus.OK);
  }

}
