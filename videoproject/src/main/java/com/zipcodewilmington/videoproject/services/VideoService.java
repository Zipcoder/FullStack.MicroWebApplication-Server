package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.exceptions.NotFoundException;
import com.zipcodewilmington.videoproject.exceptions.StorageException;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class VideoService {

    private VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Video> index(){
        return repository.findVideosByColumn();
    }

    public Video getVideoById(long id){
    return repository.findVideoByVideoId(id);
  }


    public Video storeVideo(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            String fileDownloadUri = "https://video-new-tube.herokuapp.com/videos/" + fileName;

            Video video = new Video(fileName, fileDownloadUri,
                    file.getContentType(), file.getSize(), file.getBytes());
            return repository.save(video);
        } catch (IOException ex) {
            throw new StorageException("Error storing file.", ex);
        }
    }

    public Video create(Video video) {
        return repository.save(video);
    }

    public Boolean delete(Long id){
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
