package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.entities.Tags;
import com.example.WhatTheTekBlog.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TagsController {
    private TagsService tagsService;


    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping("/tags")
    public ResponseEntity<Tags> create(@RequestBody Tags tags) {
        return new ResponseEntity<>(tagsService.create(tags), HttpStatus.CREATED);
    }



}
