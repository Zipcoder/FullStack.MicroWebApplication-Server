package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
import com.phoenixvideos.phoenixapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {
    private VideoRepository videoRepository;
    private UserRepository userRepository;
    private AmazonS3ClientService amazonS3ClientService;

    @Autowired
    public VideoService(VideoRepository videoRepository, UserRepository userRepository, AmazonS3ClientService amazonS3ClientService) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
        this.amazonS3ClientService = amazonS3ClientService;
    }

    public Video create(MultipartFile videoFile, Long user_id, String videoName, String videoDescription, String format) {
        Video newVideo = new Video();

        if(userRepository.findById(user_id).isPresent()) {
            User user = userRepository.findById(user_id).get();
            newVideo.setUser(user);
            newVideo.setName(videoName);
            newVideo.setVideoDescription(videoDescription);
            newVideo.setFormat(format);

            videoRepository.save(newVideo);

            String uniqueVideoName = generateUniqueName(videoFile.getOriginalFilename(), format, newVideo.getId());

            amazonS3ClientService.uploadFileToS3Bucket(videoFile, uniqueVideoName);

            newVideo.setPath(amazonS3ClientService.gertUrl());
            newVideo.setUniqueName(uniqueVideoName);

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

    public String generateUniqueName(String name, String format, Long id) {
        name = name.replace(".mp4", "");
        return name + "_" + id + "." + format;
    }

    public Video getVideo(Long id) {
        return videoRepository.findById(id).get();
    }

    public Video updateVideoDetails(Long id, Video video) {
        Video originalVideo = videoRepository.findById(id).get();

        originalVideo.setName(video.getName());
        originalVideo.setUniqueName(video.getUniqueName());
        originalVideo.setVideoDescription(video.getVideoDescription());
        originalVideo.setPath(video.getPath());
        originalVideo.setName(video.getName());
        originalVideo.setFormat(video.getFormat());
        originalVideo.setComments(video.getComments());

        videoRepository.save(originalVideo);
        return originalVideo;
    }

    public boolean delete(Long id) {
        videoRepository.deleteById(id);
        return true;
    }
}

