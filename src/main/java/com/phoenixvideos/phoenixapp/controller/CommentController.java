package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;

import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Set;

@RestController
public class CommentController {


    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/videos/comment/{user_id}/{video_id}")//videos/comment/1/2
    public ResponseEntity<Comment> createComment(@PathVariable("user_id") Long user_id, @PathVariable("video_id") Long video_id, @RequestBody Comment comment) {

        Comment returnComment = commentService.create(user_id,video_id,comment);
        return (returnComment == null) ? (new ResponseEntity<>(HttpStatus.BAD_REQUEST))
                : new ResponseEntity<>(returnComment,HttpStatus.CREATED);
    }

    @GetMapping("/videos/comment/{user_id}/{video_id}")//videos/comment/1/2
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