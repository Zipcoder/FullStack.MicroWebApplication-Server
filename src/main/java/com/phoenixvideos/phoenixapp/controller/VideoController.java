package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.service.UserService;
import com.phoenixvideos.phoenixapp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;


@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private UserService userService;

    Set<Video> returnList = new HashSet<>();

    @PostMapping("/videos/{user_id}")//pass the id of the user uploading
    public ResponseEntity<Video> createVideo(@PathVariable Long user_id,@RequestBody Video video) {
    //have user service find by id and get the user
        Video result = videoService.create(user_id, video);
        return (result == null) ? (new ResponseEntity<>(HttpStatus.BAD_REQUEST) )
             : new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @GetMapping("/videos/all")
    public ResponseEntity<Set<Video>> getAllVideos() {

        returnList.add(new Video("Video Object 1"));
        returnList.add(new Video("Video Object 2"));
        returnList.add(new Video("Video Object 3"));
        returnList.add(new Video("Video Object 4"));
        returnList.add(new Video("Video Object 5"));

//        returnList.add(new Video("Video1");
//        returnList.add("Video2");
//        returnList.add("Video3");
//        returnList.add("Video4");
//        returnList.add("Video5");
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> getVideo(@PathVariable Long id) {
        return new ResponseEntity<>(new Video(), HttpStatus.OK);
    }
    @GetMapping("/videos/download/{id}")
    public ResponseEntity<File> downloadVideo(@PathVariable Long id) {
        return new ResponseEntity<>(new File("path"), HttpStatus.OK);
    }
    
    @PutMapping("/videos/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video) {
        return new ResponseEntity<>(new Video(), HttpStatus.OK);
    }

    @DeleteMapping("/videos/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVideo(@PathVariable Long id) {

    }

    @GetMapping("/videos/comments/all")
    public ResponseEntity<Comment> show() {
        return new ResponseEntity<>( HttpStatus.OK);
    }





}
