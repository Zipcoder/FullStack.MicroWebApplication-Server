
package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    //Only 2 get mappings at a time otherwise I will get 500 error if I run all three
    @GetMapping("/tags")
    public ResponseEntity<Iterable<Tags>> findAll() {
        return new ResponseEntity<>(this.tagsService.findAllTags(), HttpStatus.OK);
    }

//    @GetMapping("/tags/{id}")
//    public ResponseEntity<Optional<Tags>> findTagById(@PathVariable Integer id) {
//        return new ResponseEntity<>(this.tagsService.findTagById(id), HttpStatus.OK);
//    }

    @GetMapping("/tags/{tagName}")
    public ResponseEntity<Set<Post>> findPostsByTag(@PathVariable String tagName) {
        return new ResponseEntity<>(this.tagsService.findPostsByTag(tagName), HttpStatus.OK);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<Tags> update(@PathVariable("id") Integer id,@RequestBody Tags tag) {
        return new ResponseEntity<>(this.tagsService.update(id, tag), HttpStatus.OK);
    }


    // Only one DeleteMapping (either delete by id or tagName)
//    @DeleteMapping("/tags/{id}")
//    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
//        return new ResponseEntity<>(tagsService.delete(id), HttpStatus.OK);
//    }

    @DeleteMapping("/tags/{tagName}/")
    public ResponseEntity<Boolean> delete(@PathVariable String tagName) {
        return new ResponseEntity<>(this.tagsService.delete(tagName), HttpStatus.OK);
    }


}
