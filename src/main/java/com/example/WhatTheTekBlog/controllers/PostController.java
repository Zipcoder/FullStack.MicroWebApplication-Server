package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PostController {
  @Autowired
  private PostService postService;
}
