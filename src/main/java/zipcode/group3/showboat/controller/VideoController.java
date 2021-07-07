package zipcode.group3.showboat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.service.VideoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    private VideoService service;


    public VideoController(VideoService service) {
        this.service = service;
    }

    /**
     * returns a list of videos
     */
    @GetMapping
    public ResponseEntity<List<Video>> index() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    /**
     * Gets the information of a single video by id
     * @param id - the Id of the video determined by the path variable
     * @return A response entity containing the Video as a Json
     */
    @GetMapping("/{id}")
    public ResponseEntity<Video> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    /**
     * Creates a new video from a json object
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Video> post(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description) {

        return new ResponseEntity<>(service.create(title, description, file), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Video> post(@PathVariable Long id, @RequestBody Video video) {
        return new ResponseEntity<>(service.update(id, video), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
