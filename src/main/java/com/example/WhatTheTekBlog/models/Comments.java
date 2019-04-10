package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Comments {

//    @ManyToOne
//    private User commenter;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;

    String comments;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(name = "user_comment",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(name = "post_forComment",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Post post;


    @NotNull
    private Date createdDate = new Date();

    @Transient
    Calendar calendar = Calendar.getInstance();


    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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
}
