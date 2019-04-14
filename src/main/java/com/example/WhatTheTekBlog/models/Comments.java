package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;

    private String comments;
    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Post post;

    @Transient
    private Calendar calendar = Calendar.getInstance();


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

    public AppUser getAppUser() {
      return user;
    }

    public void setAppUser(AppUser appUser) {
      this.user = appUser;
    }

    public Post getPost() {
      return post;
    }

    public void setPost(Post post) {
    this.post = post;
  }
}
