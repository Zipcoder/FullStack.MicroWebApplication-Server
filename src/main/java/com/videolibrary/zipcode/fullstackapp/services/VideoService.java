package com.videolibrary.zipcode.fullstackapp.services;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoService (VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video addVideo (Video video) {
        return videoRepository.save(video);
    }

    public Optional<Video> getVideoById (long id) {
        return videoRepository.findById ( id );
    }

    public Iterable<Video> getVideoList() {
        return videoRepository.findAll ();
    }

    public Boolean deleteVideo (long id) {
        videoRepository.deleteById ( id );
        return true;
    }

    public Video updateVideo(Long id, Video v) {
        Video video = videoRepository.getVideoById(id);
        video.setTitle(v.getTitle());
        videoRepository.save(video);
        return video;
    }
}
