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

    public Video create(Long user_id, String videoName, String videoDescription) {
        Video newVideo = new Video();

        if(userRepository.findById(user_id).isPresent()) {
            User user = userRepository.findById(user_id).get();
            newVideo.setUser(user);
            newVideo.setName(videoName);
            newVideo.setVideoDescription(videoDescription);
            videoRepository.save(newVideo);
        }
        return newVideo;
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

    public Video getVideo(Long id) {
        return videoRepository.findById(id).get();
    }

    public Video updateVideoDetails(Long id, Video video) {
        Video originalVideo = videoRepository.findById(id).get();
        originalVideo.setName(video.getName());
        videoRepository.save(originalVideo);
        return originalVideo;
    }

    public boolean delete(Long id) {
        videoRepository.deleteById(id);
        return true;
    }
}

