package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
import com.phoenixvideos.phoenixapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private VideoRepository videoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video create(Long user_id, Video video) {
        Video result = null;
        User user = userRepository.findById(user_id).orElseGet(null);
        if(user != null) {
            video.setUser(user);
            result = videoRepository.save(video);
        }
        return result;
    }

    public Iterable<Video> index() {
        return videoRepository.findAll();
    }

    public Video show(Long id) {
        return videoRepository.findById(id).get();
    }
}

