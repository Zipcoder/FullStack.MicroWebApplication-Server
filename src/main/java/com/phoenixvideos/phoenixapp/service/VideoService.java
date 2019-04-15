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
    private UserRepository userRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository, UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    public Video create(Long user_id, Video video) {
        Video result = null;
        User user = userRepository.findById(user_id).get();//.orElseGet(null);
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

    public String generateUniqueName(String name, Long id) {
        return name + "_" + id;
    }

    public void updatePath(Video video) {
        videoRepository.save(video);
    }
}

