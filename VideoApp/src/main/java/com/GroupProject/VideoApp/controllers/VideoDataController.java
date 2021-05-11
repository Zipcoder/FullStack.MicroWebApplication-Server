package com.GroupProject.VideoApp.controllers;

import com.GroupProject.VideoApp.models.Comments;
import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.services.VideoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin    // host serving JS may be different from host serving the data, need to allow CORS
public class VideoDataController {

    private final VideoDataService service;

    @Autowired
    public VideoDataController(VideoDataService service) {
        this.service = service;
    }

//    {
//            "title": "Test Video",
//            "userId": 456,
//            "lengthOfVideo": 90,
//            "viewCount": 0,
//            "description": "This is a test video",
//            "videoPostedDate": "2021-04-26",
//            "likeCount": 0,
//            "dislikeCount": 0
//    }


    @PutMapping("/video/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video){
        return new ResponseEntity<>(service.update(id,video),HttpStatus.OK);
    }

    @PatchMapping("/video/{id}")
    public ResponseEntity<Video> updateTitleDescCatg(@PathVariable Long id, @RequestBody Video video){
        return new ResponseEntity<>(service.updateTitleDescriptionCategory(id,video),HttpStatus.OK);
    }

    // get 1 video by id
    @GetMapping("/video/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id){
        return new ResponseEntity<>(service.getOne(id),HttpStatus.OK);
    }

    // get all videos
    @GetMapping("/video")
    public ResponseEntity<Iterable<Video>> getAllVideos(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    // get all video ids
    @GetMapping("/video/allIds")
    public ResponseEntity<Iterable<Long>> getAllVideoIds(){
        return new ResponseEntity<>(service.getAllIds(),HttpStatus.OK);
    }

    // get top 5 most watched videos
    @GetMapping("/video/trending")
    public ResponseEntity<Iterable<Video>> getTrendingVideos(){
        return new ResponseEntity<>(service.getTrending(),HttpStatus.OK);
    }

    // get all News videos
    @GetMapping("/video/news")
    public ResponseEntity<List<Video>> getAllNewsVideos(){
        return new ResponseEntity<>(service.getAllCategory("News"),HttpStatus.OK);
    }

    // get all Sports videos
    @GetMapping("/video/sports")
    public ResponseEntity<List<Video>> getAllSportsVideos(){
        return new ResponseEntity<>(service.getAllCategory("Sports"),HttpStatus.OK);
    }

    // get all Entertainment videos
    @GetMapping("/video/entertainment")
    public ResponseEntity<List<Video>> getAllEntertainmentVideos(){
        return new ResponseEntity<>(service.getAllCategory("Entertainment"),HttpStatus.OK);
    }

    // get all Music videos
    @GetMapping("/video/music")
    public ResponseEntity<List<Video>> getAllMusicVideos(){
        return new ResponseEntity<>(service.getAllCategory("Music"),HttpStatus.OK);
    }

    // get all Traveling videos
    @GetMapping("/video/traveling")
    public ResponseEntity<List<Video>> getAllTravelingVideos(){
        return new ResponseEntity<>(service.getAllCategory("Traveling"),HttpStatus.OK);
    }

    // get all Fitness videos
    @GetMapping("/video/fitness")
    public ResponseEntity<List<Video>> getAllFitnessVideos(){
        return new ResponseEntity<>(service.getAllCategory("Fitness"),HttpStatus.OK);
    }

    // get all Video Games videos
    @GetMapping("/video/videogames")
    public ResponseEntity<List<Video>> getAllVideoGamesVideos(){
        return new ResponseEntity<>(service.getAllCategory("Video Games"),HttpStatus.OK);
    }

    @DeleteMapping("/video/delete/{id}")
    public ResponseEntity<Boolean> deleteVideo(@PathVariable Long id){
        return new ResponseEntity<>(service.remove(id),HttpStatus.OK);
    }

    @PatchMapping("/video/like/plus/{id}")
    public ResponseEntity<Video> increaseLikeCount(@PathVariable Long id) {
        return new ResponseEntity<>(service.incrementLikes(id), HttpStatus.OK);
    }

    @PatchMapping("/video/like/minus/{id}")
    public ResponseEntity<Video> decreaseLikeCount(@PathVariable Long id) {
        return new ResponseEntity<>(service.decrementLikes(id), HttpStatus.OK);
    }

    @PatchMapping("/video/dislike/plus/{id}")
    public ResponseEntity<Video> increaseDislikeCount(@PathVariable Long id) {
        return new ResponseEntity<>(service.incrementDislikes(id), HttpStatus.OK);
    }

    @PatchMapping("/video/dislike/minus/{id}")
    public ResponseEntity<Video> decreaseDislikeCount(@PathVariable Long id) {
        return new ResponseEntity<>(service.decrementDislikes(id), HttpStatus.OK);
    }

    @PatchMapping("/video/addComment/{id}")
    public ResponseEntity<Video> addComment(@PathVariable Long id, @RequestBody Comments comment) {
        return new ResponseEntity<>(service.addComment(id, comment), HttpStatus.OK);
    }

    @PatchMapping("/video/incrementViewCount/{id}")
    public ResponseEntity<Video> increaseViewCount(@PathVariable Long id){
        return new ResponseEntity<>(service.incrementViewCount(id),HttpStatus.OK);
    }
}
