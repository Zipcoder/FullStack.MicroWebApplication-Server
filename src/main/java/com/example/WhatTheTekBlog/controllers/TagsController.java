
package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class TagsController {
    private TagsService tagsService;


    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping("/createTag")
    public ResponseEntity<Tags> create(@RequestBody Tags tags) {
        return new ResponseEntity<>(tagsService.createTags(tags), HttpStatus.CREATED);
    }

    @GetMapping("/tags")
    public ResponseEntity<Iterable<Tags>> findAll() {
        return new ResponseEntity<>(this.tagsService.findAllTags(), HttpStatus.OK);
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<Optional<Tags>>findTagById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.tagsService.findTagById(id), HttpStatus.OK);
    }

    @GetMapping("/tags/posts/{tagName}")
    public ResponseEntity<Set<Post>> findPostsByTag(@PathVariable String tagName) {
        return new ResponseEntity<>(this.tagsService.findPostsByTag(tagName), HttpStatus.OK);
    }

//    @GetMapping("/post/tags/{postId}")
//    public ResponseEntity<Set<Tags>> findTagsByPost(@PathVariable Integer postId) {
//        return new ResponseEntity<>(this.tagsService.findTagsByPost(postId), HttpStatus.OK);
//    }

    @PutMapping("/updateTag/{id}")
    public ResponseEntity<Tags> update(@PathVariable("id") Integer id,@RequestBody Tags tag) {
        return new ResponseEntity<>(this.tagsService.update(id, tag), HttpStatus.OK);
    }

//    @DeleteMapping("/tags/{id}")
//    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
//        return new ResponseEntity<>(tagsService.delete(id), HttpStatus.OK);
//    }

    @DeleteMapping("/deleteTags/{tagName}")
    public ResponseEntity<Boolean> delete(@PathVariable String tagName) {
        return new ResponseEntity<>(this.tagsService.deleteTags(tagName), HttpStatus.OK);
    }


    @GetMapping("/tags/filteredPosts/{tagNames}")
    public ResponseEntity<Set<Post>> findFilteredPostsByTag(@PathVariable List<String> tagNames ) {
        return new ResponseEntity<>(this.tagsService.findFilteredPostsByTag(tagNames), HttpStatus.OK);
    }


}


