package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.UserComment;
import com.zipcodewilmington.videoproject.models.VideoComments;
import com.zipcodewilmington.videoproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommentController {

  private CommentService commentService;

  @Autowired
  public CommentController(CommentService service) {
    this.commentService = service;
  }

  @PostMapping(value = "/videos/{videoId}/comments")
  public void postVideoComment(@RequestBody UserComment userComment, @PathVariable("videoId") int videoId) {
    commentService.postVideoComments(videoId, userComment);
  }

  @GetMapping(value = "/videos/{videoId}/comments")
  public ResponseEntity<VideoComments> getCommentsByVideoId(@PathVariable("videoId") int videoId) {
    return new ResponseEntity<>(commentService.getVideoComments(videoId), HttpStatus.OK);
  }


}



