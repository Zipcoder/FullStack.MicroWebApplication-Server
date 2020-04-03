package com.videolibrary.zipcode.fullstackapp.services;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Video getVideo (Long id) {
        return videoRepository.getVideoById ( id );
    }

    public Iterable<Video> getVideoList() {
        return videoRepository.findAll ();
    }

    public Boolean deleteVideo (Long id) {
        videoRepository.deleteById ( id );
        return true;
    }
}
