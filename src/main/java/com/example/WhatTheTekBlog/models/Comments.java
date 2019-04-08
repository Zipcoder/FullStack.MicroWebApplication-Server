package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comments {
    @ManyToOne
    private User commenter;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long comment_id;

  String comments;

  @ManyToOne(cascade = CascadeType.ALL)
  User user;

  @ManyToOne(cascade = CascadeType.ALL)
  Post post;

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
