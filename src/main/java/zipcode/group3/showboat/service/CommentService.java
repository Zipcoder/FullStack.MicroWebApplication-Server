package zipcode.group3.showboat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import zipcode.group3.showboat.model.Comment;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.CommentRepository;
import zipcode.group3.showboat.repository.VideoRepository;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private VideoRepository videoRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, VideoRepository videoRepository) {
        this.commentRepository = commentRepository;
        this.videoRepository = videoRepository;
    }


    public Comment addComment( Comment comment,  Long videoid) {

        //Get the video
        Video video = videoRepository.findById(videoid).get();
        comment.setVideo(video);
        return commentRepository.save(comment);

    }
}
