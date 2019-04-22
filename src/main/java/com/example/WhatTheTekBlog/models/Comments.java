package com.example.WhatTheTekBlog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String comments;
    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private Date createdDate = new Date();


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", comments='" + comments + '\'' +
                ", user=" + user +
                ", post=" + post +
                ", createdDate=" + createdDate +
                '}';
    }
}
