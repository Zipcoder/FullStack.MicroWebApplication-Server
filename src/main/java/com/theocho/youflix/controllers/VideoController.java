package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Video;
import com.theocho.youflix.services.VideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/labtest")
public class VideoController {

    @Resource
    private VideoServices videoServices;

    @Autowired
    VideoController(VideoServices videoServices) {
        this.videoServices = videoServices;
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Optional<Video>> show(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(videoServices.show(id), HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.videoServices.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.videoServices.deleteFileFromS3Bucket(fileUrl);
    }

    @PostMapping("/makeVideo")
    public ResponseEntity createVideo(@RequestBody Video video) {
        videoServices.createVideoRecord(video);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
