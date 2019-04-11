package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.repository.CommentRepository;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
import com.phoenixvideos.phoenixapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository =commentRepository;
    }

    @Autowired
    public VideoRepository videoRepository;

    @Autowired
    public UserRepository userRepository;

    public Comment create(Long user_id, Long video_id, Comment comment) {

        Video videoResult = null;
        User userResult = null;
        Comment commentResult = null;
        User user = userRepository.findById(user_id).orElseGet(null);
        Video video = videoRepository.findById(video_id).orElseGet(null);
        if(user != null && video!= null) {
            comment.setUser(user);
            comment.setVideo(video);

            commentResult = commentRepository.save(comment);
        }
        return commentResult;
    }

    public Iterable<Comment> index() {
        return commentRepository.findAll();
    }

    public Comment show(Long id) {
        return commentRepository.findById(id).get();
    }

//    public User update(Long id, User newUser) {
//        User user = userRepository.findById(id).get();
//        user.setFirstName(newUser.getFirstName());
//        user.setLastName(newUser.getLastName());
//        user.setEmail(newUser.getEmail());
//        user.setPassword(newUser.getPassword());
//        user.setUserName(newUser.getUserName());
//        return userRepository.save(user);
//    }
}