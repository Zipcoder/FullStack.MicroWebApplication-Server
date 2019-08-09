package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.exceptions.NotFoundException;
import com.zipcodewilmington.videoproject.exceptions.StorageException;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Service
public class VideoService {

  private VideoRepository repository;

  @Autowired
  public VideoService(VideoRepository repository) {
    this.repository = repository;
  }

  public Iterable<Video> index() {
    return repository.findVideosByColumn();
  }

  public Video getVideoById(long id) {
    return repository.findVideoByVideoId(id);
  }


  public Video storeVideo(MultipartFile file, String title, String userId) {
    try {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      String fileDownloadUri = "https://video-new-tube.herokuapp.com/videos/" + fileName;

      Video video = repository.save(new Video(fileName, fileDownloadUri,
        file.getContentType(), file.getSize(), file.getBytes()));

      video.setVideoPath(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("videos/")
        .path(String.valueOf(video.getVideoId()))
        .toUriString());

      if (!title.equals("")) {
        video.setVideoName(title);
      }
      video.setUserId(userId);
      return update(video.getVideoId(), video);
    } catch (IOException ex) {
      throw new StorageException("Error storing file.", ex);
    }
  }

  public Video create(Video video) {
    return repository.save(video);
  }

  public Boolean delete(Long id) {
    repository.deleteById(id);
    return true;
  }


  public Video getFile(Long fileId) {
    return repository.findById(fileId)
      .orElseThrow(() -> new NotFoundException("File not found with id " + fileId));
  }

  public Video update(Long id, Video newVideoData) {
    Video video = getFile(id);
    video.setVideoPath(newVideoData.getVideoPath());
    video.setVideoName(newVideoData.getVideoName());
    video.setUserId(newVideoData.getUserId());
    return repository.save(video);
  }
}
