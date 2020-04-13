package com.videolibrary.zipcode.fullstackapp.controllers;

import com.videolibrary.zipcode.fullstackapp.models.Video;

import com.videolibrary.zipcode.fullstackapp.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoController {

    VideoService videoService ;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/video")
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        return new ResponseEntity<> ( videoService.addVideo (video), HttpStatus.CREATED);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<?>getVideoById(@PathVariable long id) {
        return new ResponseEntity<> ( videoService.getVideoById(id), HttpStatus.FOUND );
    }

    @GetMapping("/video")
    public ResponseEntity<Iterable<Video>> getVideoList() {
        return new ResponseEntity<> ( videoService.getVideoList (), HttpStatus.FOUND );
    }

    @PutMapping("/video")
    public ResponseEntity<Video> updateVideo(@RequestBody Video video) {
            return new ResponseEntity<> ( videoService.addVideo ( video ), HttpStatus.CREATED );
    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<Boolean> deleteVideo(@PathVariable ("id") long id) {
        return new ResponseEntity<> ( videoService.deleteVideo ( id ), HttpStatus.OK );
    }

}
