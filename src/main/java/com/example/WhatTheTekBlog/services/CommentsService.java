package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CommentsService {

        private CommentsRepository commentsRepository;


        @Autowired
        public CommentsService(CommentsRepository commentsRepository) {
            this.commentsRepository = commentsRepository;
        }


        public Comments create(Comments comments){
            for (Comments comments1: commentsRepository.findAll()) {
                if(comments1.getComment_id().equals(comments.getComments())) {
                    throw new IllegalArgumentException();
                }
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


//    public Comments updateComments(Long comment_id, Comments updateComments) {
//        updateComments.setComment_id(comment_id);
//        Comments comments1 = commentsRepository.save(updateComments);
//        return comments1;
//    }


        public Boolean delete(Long comment_id) {
            commentsRepository.deleteById(comment_id);
            return true;
        }

        public Boolean delete(String comment) {
            List<Comments> listOfComments = (ArrayList<Comments>) this.commentsRepository.findAll();

            for (Comments c: listOfComments) {
                if(c.getComments().equals(comment)) {
                    commentsRepository.delete(c);
                }
            }

            return true;
        }

    public List <Comments> findAllCommentByPost(Long post_id) {
            List<Comments> comments = new ArrayList<>();

            for(Comments c: commentsRepository.findAll()){
                if(c.getPost().getPostID().equals(post_id)){
                    comments.add(c);
                }
            }
            return comments;
    }

    }

