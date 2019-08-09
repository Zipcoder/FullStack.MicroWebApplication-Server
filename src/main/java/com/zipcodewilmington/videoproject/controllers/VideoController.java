package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.services.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/videos")
public class VideoController {

  private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
  private VideoService service;

  @Autowired
  public VideoController(VideoService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Iterable<Video>> index() {
    return new ResponseEntity<>(service.index(), HttpStatus.OK);
  }

  @GetMapping(value = "videostorage/{id}")
  public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
    return new ResponseEntity<>(service.getVideoById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/uploadFile")
  public ResponseEntity<Video> uploadFile(@RequestPart MultipartFile file, @RequestParam String title, @RequestParam String userId) {
    return new ResponseEntity<>(service.storeVideo(file, title, userId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Video> create(@RequestBody Video video) {
    return new ResponseEntity<>(service.create(video), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video video) {
    return new ResponseEntity<>(service.update(id, video), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
    return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
  }

  @GetMapping("/{fileId}")
  public ResponseEntity<Resource> getVideo(@PathVariable Long fileId) {
    Video video = service.getFile(fileId);

    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(video.getVideoType()))
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + video.getVideoName() + "\"")
      .body(new ByteArrayResource(video.getVideoBytes()));
  }


}
