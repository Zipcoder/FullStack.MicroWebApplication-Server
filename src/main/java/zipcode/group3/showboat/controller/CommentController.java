package zipcode.group3.showboat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zipcode.group3.showboat.model.Comment;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.CommentRepository;
import zipcode.group3.showboat.repository.VideoRepository;
import zipcode.group3.showboat.service.CommentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private CommentRepository commentRepository;
    private VideoRepository videoRepository;
    private CommentService commentService;

    @Autowired
    public CommentController(CommentRepository commentRepository, VideoRepository videoRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.videoRepository = videoRepository;
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> commentslist() {
        return (List<Comment>) commentRepository.findAll();
    }

    @RequestMapping(value = "comments/{id}", method = RequestMethod.GET)
    public Comment getComment (@PathVariable Long id) {
        return commentRepository.getOne(id);
    }

    @PostMapping("/comments/{videoid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable Long videoid) {

        return new ResponseEntity<>(commentService.addComment(comment, videoid), HttpStatus.CREATED);
    }

    @GetMapping("/comments/video/{videoid}")
    public ResponseEntity<List<Comment>> listcomments(@PathVariable Long videoid) {
        return new ResponseEntity<>(commentRepository.findByVideoId(videoid),HttpStatus.OK);
    }


}




