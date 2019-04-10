package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.services.CommentsService;
import com.example.WhatTheTekBlog.services.TagsService;
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

//    @Autowired
//    private CommentsRepository commentsRepository;
//
////    @Autowired
////    public CommentsController(CommentsRepository commentsRepository) {
////        this.commentsRepository = commentsRepository;
////    }
//
//    @PostMapping("/comments")
//    public ResponseEntity<String> createComments(@RequestBody Comments comments) {
//        try {
//            Comments retunedComments = commentsRepository.save(comments);
//            return new ResponseEntity<String>("Comments added successfully", HttpStatus.CREATED);
//        }catch (Exception ex){
//            return  new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/comment")
//    public ResponseEntity<Comments> createComment(@RequestBody Comments comment) {
//       // try {
//            Comments retunedComment = commentsRepository.save(comment);
//            return new ResponseEntity<Comments>(retunedComment, HttpStatus.CREATED);
////        }catch (Exception ex){
////            return  new ResponseEntity<Comments>(ex.getMessage()  , HttpStatus.INTERNAL_SERVER_ERROR);
////        }
//    }
//
//    @GetMapping("/comments/{comment_id}")
//    public ResponseEntity<Comments> getComments(@PathVariable long comment_id) {
//
//        Optional<Comments> comments = commentsRepository.findById(comment_id);
//        return new ResponseEntity<Comments>(comments.get(), HttpStatus.OK);
//
//    }
//
//    @GetMapping("/comments/")
//    public ResponseEntity<List<Comments>> getAllComments() {
//        List<Comments> commentsReturned = (List<Comments>) commentsRepository.findAll();
//        return new ResponseEntity<>(commentsReturned, HttpStatus.OK);
//    }
//
//    @PutMapping("/comments/{comment_id}")
//    public ResponseEntity<String> updatePerson(@PathVariable long comment_id, @RequestBody Comments comments) {
//        comments.setComment_id(comment_id);
//        Comments comments1 = commentsRepository.save(comments);
//        return new ResponseEntity<>("Updated Comment", HttpStatus.OK);
//
//
//    }
//
//    @DeleteMapping("/comments/{comment_id}")
//    public ResponseEntity<Void> DeletePerson(@PathVariable long comment_id) {
//        try {
//            commentsRepository.deleteById(comment_id);
//            return ResponseEntity.noContent().build();
//        } catch ( NoSuchElementException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}

//ResourceNotFoundExcepion

    private CommentsService commentsService;


    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/comments")
    public ResponseEntity<Comments> create(@RequestBody Comments comments) {
        return new ResponseEntity<>(commentsService.create(comments), HttpStatus.CREATED);
    }

    //Only 2 get mappings at a time otherwise I will get 500 error if I run all three
    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comments>> findAll() {
        return new ResponseEntity<>(this.commentsService.findAllComments(), HttpStatus.OK);
    }

//    @GetMapping("/tags/{id}")
//    public ResponseEntity<Optional<Tags>> findTagById(@PathVariable Integer id) {
//        return new ResponseEntity<>(this.tagsService.findTagById(id), HttpStatus.OK);
//    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> update(@PathVariable("id") Long id,@RequestBody Comments comments) {
        return new ResponseEntity<>(this.commentsService.updateComments(id, comments), HttpStatus.OK);
    }


    // Only one DeleteMapping (either delete by id or tagName)
//    @DeleteMapping("/tags/{id}")
//    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
//        return new ResponseEntity<>(tagsService.delete(id), HttpStatus.OK);
//    }

    @DeleteMapping("/tags/{tagName}")
    public ResponseEntity<Boolean> delete(@PathVariable String tagName) {
        return new ResponseEntity<>(this.commentsService.delete(tagName), HttpStatus.OK);
    }


}
