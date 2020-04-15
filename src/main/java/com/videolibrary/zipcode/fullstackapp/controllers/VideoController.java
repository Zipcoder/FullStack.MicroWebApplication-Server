package com.videolibrary.zipcode.fullstackapp.controllers;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/Video/")
public class VideoController {

    private VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return this.service.show ( id )
                .map ( video -> ResponseEntity
                .ok ()
                .body ( video ))
                .orElse ( ResponseEntity
                .notFound ()
                .build ());
    }

    @PostMapping("create")
    public ResponseEntity<Video> create(@RequestBody Video v) {
        return new ResponseEntity<>(service.create(v), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video v) {
        return new ResponseEntity<>(service.update(id, v), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Video> currentVideo = service.show (id);
        return  currentVideo
        .map(video -> {
            try {
                service.delete ( video.getId () );
            } catch (Exception e) {
                e.printStackTrace ();
            }
            return ResponseEntity.ok ().build ();
        })
          .orElse ( (ResponseEntity.notFound ().build ()) );
    }

    @PostMapping("upload")
    public ResponseEntity<Video> uploadVideo(@RequestParam String videoName, @RequestPart(value = "file") MultipartFile multipartFile) throws Exception {
        Video tempVideo = service.saveVideo(videoName, multipartFile);
        if(tempVideo != null){
            return new ResponseEntity<>(tempVideo, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
