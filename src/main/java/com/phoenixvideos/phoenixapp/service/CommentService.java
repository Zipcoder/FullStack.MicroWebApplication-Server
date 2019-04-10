package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.Comment;
import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.repository.CommentRepository;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository =commentRepository;
    }

    public Comment create(Comment comment) {
        System.out.println(comment);
        return commentRepository.save(comment);
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