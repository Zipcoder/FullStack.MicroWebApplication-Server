
package com.example.WhatTheTekBlog.models;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.annotations.Type;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long postID;

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
  private Date createdDate = new Date();

  @Transient
  Calendar calendar = Calendar.getInstance();

//  @OneToMany(cascade = CascadeType.ALL,
//    fetch = FetchType.LAZY,
//    mappedBy = "post")
//  private Set<Comments> comments = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JoinTable(name = "post_tags",
      joinColumns = {@JoinColumn(name = "post_id", nullable = false ,updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "tag_id",nullable = false, updatable = false)})
  private Set<Tags> tagsSet = new HashSet<>();

//  @ManyToOne(cascade = CascadeType.ALL,
//  fetch = FetchType.LAZY)
//  @JoinTable(name = "user_post",
//    joinColumns = @JoinColumn(name = "post_id"),
//    inverseJoinColumns = @JoinColumn(name = "user_id"))
//  private User creater;

  public Post(@NotNull @Size(max = 100) String postTitle, @NotNull @Size(max = 250) String postDescription, @NotNull String postContent,
             List<Comments> comments, List<Tags> tagsList, User author) {
    this.postTitle = postTitle;
    this.postSummary = postDescription;
    this.postContent = postContent;
    this.createdDate = calendar.getTime();
   // this.comments = comments;
   // this.tagsList = tagsList;
    //this.creater = author;
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

//  public Set<Comments> getComments() {
//    return comments;
//  }
//
//  public void setComments(Set<Comments> comments) {
//    this.comments = comments;
//  }

//  public List<Tags> getTagsList() {
//    return tagsList;
//  }
//
//  public void setTagsList(List<Tags> tagsList) {
//    this.tagsList = tagsList;
//  }

//  public User getUserID() {
//    return creater;
//  }
//
//  public void setUserID(User author) {
//    this.creater = author;
//  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }




}
