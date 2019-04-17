package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.service.AmazonS3ClientService;
import com.phoenixvideos.phoenixapp.service.UserService;
import com.phoenixvideos.phoenixapp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;


@RestController
public class VideoController {
    private final VideoService videoService;
    private final AmazonS3ClientService amazonS3ClientService;

    @Autowired
    public VideoController(VideoService videoService, AmazonS3ClientService amazonS3ClientService) {
        this.videoService = videoService;
        this.amazonS3ClientService = amazonS3ClientService;
    }

    @PostMapping("/videos/{user_id}")//pass the id of the user uploading
    public ResponseEntity<Video> createVideo(@RequestPart(value = "file") MultipartFile videoFile, @PathVariable Long user_id, @RequestPart(value = "name") String videoName, @RequestPart(value = "desc") String videoDescription) {
        Video createdVideo = videoService.create(user_id, videoName, videoDescription);
        String uniqueVideoName = videoService.generateUniqueName(videoFile.getName(), createdVideo.getId());
        amazonS3ClientService.uploadFileToS3Bucket(videoFile, uniqueVideoName);
        createdVideo.setPath(amazonS3ClientService.gertUrl());
        videoService.updatePath(createdVideo);
        return new ResponseEntity<>(createdVideo, HttpStatus.CREATED);
    }


    @GetMapping("/videos/all")
    public ResponseEntity<Iterable<Video>> getAllVideos() {
        return new ResponseEntity<>(videoService.index(), HttpStatus.OK);
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> getVideo(@PathVariable Long id) {
        return new ResponseEntity<>(videoService.getVideo(id), HttpStatus.OK);
    }
    
    @PutMapping("/videos/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video) {
        return new ResponseEntity<>(videoService.updateVideoDetails(id, video), HttpStatus.OK);
    }

    @DeleteMapping("/videos/{id}")
    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Boolean> deleteVideo(@PathVariable Long id) {
        Video video = videoService.getVideo(id);
        amazonS3ClientService.deleteFileFromS3Bucket(video.getUniqueName());

        return new ResponseEntity<>(videoService.delete(id), HttpStatus.NO_CONTENT);
    }
}
