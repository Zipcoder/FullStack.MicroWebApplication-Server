package com.videolibrary.zipcode.fullstackapp.services;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video create(Video v) {
        return videoRepository.save(v);
    }

    public Video show(Long id) {
        return videoRepository.getVideoById(id);
    }

    public List<Video> index() {
        return videoRepository.findAll();
    }

    public Video update(Long id, Video v) {
        Video video = videoRepository.getVideoById(id);
        video.setTitle(v.getTitle());
        videoRepository.save(video);
        return video;
    }

    public boolean delete(Long id) {
        videoRepository.deleteById(id);
        return true;
    }

    public File convertMultiPartFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return convertedFile;
    }

}
