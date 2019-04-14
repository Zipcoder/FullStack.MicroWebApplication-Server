
package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long postID;


  @NotNull
  @Size(max = 100)
  @Column(nullable = false)
  private String postTitle;

  @NotNull
  @Size(max = 250)
  @Column(nullable = false)
  @Type(type = "text")
  private String postSummary;

  @NotNull
  @Lob
  @Column(nullable = false)
  private String postContent;

  @NotNull
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date createdDate = new Date();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
  private Set<Comments> comments = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listOfPosts")
  private Set<Tags> tagsSet = new HashSet<>();

  @ManyToOne(cascade = CascadeType.ALL)
  private User creator;

  public Post(@NotNull @Size(max = 100) String postTitle, @NotNull @Size(max = 250) String postDescription, @NotNull String postContent,
             Set<Comments> comments, Set<Tags> tags, User author) {
    this.postTitle = postTitle;
    this.postSummary = postDescription;
    this.postContent = postContent;
    this.createdDate = new Date();
    this.comments = comments;
    this.tagsSet = tags;
    this.creator = author;
  }

  public Post() {
  }

  public Long getPostID() {
    return postID;
  }

  public void setPostID(Long postID) {
    this.postID = postID;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostSummary() {
    return postSummary;
  }

  public void setPostSummary(String postSummary) {
    this.postSummary = postSummary;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public Set<Comments> getComments() {
    return comments;
  }

  public void setComments(Set<Comments> comments) {
    this.comments = comments;
  }

  public Set<Tags> getTagsSet() {
    return tagsSet;
  }

  public void setTagsSet(Set<Tags> tagsSet) {
    this.tagsSet = tagsSet;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }




}
