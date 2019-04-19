package com.example.WhatTheTekBlog.services;

import com.auth0.jwt.JWT;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.WhatTheTekBlog.models.User;

import java.util.*;
@Service
public class CommentsService {

        private CommentsRepository commentsRepository;
        private UserRepository userRepository;


        @Autowired
        public CommentsService(CommentsRepository commentsRepository, UserRepository userRepository) {
            this.userRepository = userRepository;
            this.commentsRepository = commentsRepository;
        }

        public Comments create(String token, Comments comments){
            String name = JWT.decode(token).getClaim("nickname").asString();
            if (userRepository.findByName(name).isPresent()) {
                comments.setUser(userRepository.findByName(name).get());
            }
            return commentsRepository.save(comments);
        }

        public Iterable<Comments> findAllComments() {
            return commentsRepository.findAll();
        }

        public Optional<Comments> findCommentById(Long comment_id) {
            return commentsRepository.findById(comment_id);
        }


        public Comments updateComments(Long comment_id, Comments updatedComment) {
            Comments originalComment = commentsRepository.findById(comment_id).get();
            originalComment.setComments(updatedComment.getComments());
            commentsRepository.save(originalComment);
            return originalComment;
        }

        public Boolean delete(Long comment_id) {
            commentsRepository.deleteById(comment_id);
            return true;
        }

    public List <Comments> findAllCommentByPost(Long post_id) {
            List<Comments> comments = new ArrayList<>();

            for(Comments c: commentsRepository.findAll()){
                if(c.getPost() != null && c.getPost().getPostID().equals(post_id)){
                    comments.add(c);
                }
            }
            return comments;
    }

    }

