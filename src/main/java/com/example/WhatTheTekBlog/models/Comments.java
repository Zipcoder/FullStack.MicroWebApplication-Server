package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comments {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long comment_id;

  private String comments;
  @ManyToOne(cascade = CascadeType.ALL)
  private User user;

  @ManyToOne(cascade = CascadeType.ALL)
  @JsonIgnore
  private Post post;

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
