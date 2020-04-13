package com.theocho.youflix.services;


import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServices {

    private final VideoRepository videoRepository;

    public VideoServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

//    private AmazonS3 s3client;
//
//    @Value("${amazonProperties.endpointUrl}")
//    private String endpointUrl;
//    @Value("${amazonProperties.bucketName}")
//    private String bucketName;
//    @Value("${amazonProperties.accessKey}")
//    private String accessKey;
//    @Value("${amazonProperties.secretKey}")
//    private String secretKey;

    public Video create(Video video) {
        return videoRepository.save(video);
    }

    public Video showOne(Long id) {
        return videoRepository.findById(id).get();
    }

    public Iterable<Video> showAll(){
        return videoRepository.findAll();
    }

}
