package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.UserComment;
import com.zipcodewilmington.videoproject.models.VideoComments;
import com.zipcodewilmington.videoproject.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentService {


  private CommentRepository repository;

  @Autowired
  public CommentService(CommentRepository repository) {
    this.repository = repository;
  }


  public VideoComments getVideoComments(int videoId){
        Collection<Comment> comments = repository.findCommentByVideoId(videoId);
        //converting database to JSON
        List<UserComment> userComments = new ArrayList<>();
        for(Comment comment : comments) {
            UserComment userComment = new UserComment();
            userComment.setUserId(comment.getUserId());
            userComment.setText(comment.getCommentText());
            userComment.setCreatedDate(comment.getCreateDate().toString());
            userComments.add(userComment);
        }
        VideoComments videoComments = new VideoComments();
        videoComments.setVideoId(videoId);
        videoComments.setComments(userComments);
        return videoComments;
    }

    public Iterable<Comment> getCommentsByVideoId(int videoId){
      return repository.findCommentsByVideoId(videoId);
    }

    public void postVideoComments(int videoId, UserComment userComment) {
        Comment comment = new Comment();
        comment.setCommentText(userComment.getText());
        comment.setUserId(userComment.getUserId());
        comment.setCreateDate(new Date());
        comment.setVideoId(videoId);
        repository.save(comment);
    }


}
