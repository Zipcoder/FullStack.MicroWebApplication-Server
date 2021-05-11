package com.GroupProject.VideoApp.services;

import com.GroupProject.VideoApp.models.Comments;
import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.repositories.VideoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoDataService {

    private VideoDataRepository repository;

    @Autowired
    public VideoDataService(VideoDataRepository repository) {
        this.repository = repository;
    }

    public List<Long> getAllIds() {
        List<Video> videos = new ArrayList<>();
        return this.getAll()
            .stream()
            .map( (v) -> v.getVideoId() )
            .collect(Collectors.toList());
    }

    public List<Video> getAll() {
        List<Video> allVideos = new ArrayList<>();
        for (Video v : repository.findAll()) {
            allVideos.add(v);
        }
        Collections.sort(allVideos);
        return allVideos;
    }

    public List<Video> getAllCategory(String category) {
        List<Video> allVideosInCategory = new ArrayList<>();
        for (Video v : repository.findAll()) {
            if (v.getCategory().equals(category)) {
                allVideosInCategory.add(v);
            }
        }
        Collections.sort(allVideosInCategory);
        return allVideosInCategory;
    }

    public Iterable<Video> getTrending() {
        List<Video> topFiveVideos = new ArrayList<>();

        for (Video v : this.getAll()
                .stream()
                .sorted((video1, video2) -> {
                    if(video1.getViewCount() == video2.getViewCount()){
                        return 0;
                    }
                    else if(video1.getViewCount() > video2.getViewCount()){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                })
                .limit(5)
                .collect(Collectors.toList())) {
            topFiveVideos.add(v);
        }
        return topFiveVideos;
    }


    // orElse(null) explanation:
    // https://stackoverflow.com/questions/44101061/missing-crudrepositoryfindone-method
    public Video getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Video add(Video video) {
        return repository.save(video);
    }

    public Video update(Long id, Video video) {
        Video temp = repository.findById(id).orElse(null);
        temp.setTitle(video.getTitle());
        temp.setUserId(video.getUserId());
        temp.setLengthOfVideo(video.getLengthOfVideo());
        temp.setViewCount(video.getViewCount());
        temp.setDescription(video.getDescription());
        temp.setVideoPostedDate(video.getVideoPostedDate());
        temp.setLikeCount(video.getLikeCount());
        temp.setDislikeCount(video.getDislikeCount());
        return repository.save(temp);
    }

    public Video updateTitleDescriptionCategory(Long id, Video video) {
        Video temp = repository.findById(id).orElse(null);
        temp.setTitle(video.getTitle());
        temp.setDescription(video.getDescription());
        temp.setCategory(video.getCategory());
        temp.setVideoPostedDate(video.getVideoPostedDate());
        return this.repository.save(temp);
    }

    public Boolean remove(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean removeList(List<Video> videoList) {
        repository.deleteAll(videoList);
        return true;
    }

    public Video incrementLikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.incrementLikeCount();
        return repository.save(temp);
    }

    public Video decrementLikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.decrementLikeCount();
        return repository.save(temp);
    }

    public Video incrementDislikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.incrementDislikeCount();
        return repository.save(temp);
    }

    public Video decrementDislikes(Long id) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.decrementDislikeCount();
        return repository.save(temp);
    }

    public Video addComment(Long id, Comments comment) {
        Video temp = repository.findById(id).orElse(null);
        assert temp != null;
        temp.addCommentToList(comment);
        return repository.save(temp);
    }

    public Video incrementViewCount(Long id) {
        Video temp = repository.findById(id).orElse(null);
        temp.incrementViewCount();
        return repository.save(temp);
    }

}
