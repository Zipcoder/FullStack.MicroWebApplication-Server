package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import com.theocho.youflix.services.VideoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost"})
public class VideoController {

    @Autowired
    private VideoServices videoServices;
    public static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);


    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoServices videoServices) {
        this.videoServices = videoServices;
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        LOGGER.info("Request recieved");
        return new ResponseEntity(videoServices.create(video), HttpStatus.CREATED);
    }

    @GetMapping("/")
    String hello(){
        return "Hello World";
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> show(@PathVariable Long id) {
        return new ResponseEntity<>(videoServices.showOne(id), HttpStatus.OK);
    }

    @GetMapping("/videos")
    public ResponseEntity<Iterable<Video>> showAllVideos(){
        return new ResponseEntity<>(videoServices.showAll(),HttpStatus.OK);
    }

//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
//        return this.videoServices.uploadFile(file);
//    }
//
//    @DeleteMapping("/deleteFile")
//    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
//        return this.videoServices.deleteFileFromS3Bucket(fileUrl);
//    }

}
