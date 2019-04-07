package com.example.WhatTheTekBlog.entities;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long postID;

  @NotNull
  @Size(max = 100)
  @Column(unique = true)
  private String postTitle;

  @NotNull
  @Size(max = 250)
  private String postDescription;

  @NotNull
  @Lob
  private String postContent;

  @NotNull
  private Date createdDate = new Date();

//  @OneToMany(cascade = CascadeType.ALL,
//    fetch = FetchType.LAZY,
//    mappedBy = "post")
//  private Set<Comments> comments = new HashSet<>();

//  @ManyToMany(cascade = CascadeType.ALL,
//  fetch = FetchType.LAZY)
//  @JoinTable(name = "post_tag",
//      joinColumns = @JoinColumn(name = "post_id"),
//      inverseJoinColumns = @JoinColumn(name = "tag_id" ))
//  private List<Tags> tagsList;

//  @ManyToOne(cascade = CascadeType.ALL,
//  fetch = FetchType.LAZY)
//  @JoinTable(name = "user_post",
//    joinColumns = @JoinColumn(name = "post_id"),
//    inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Long userID;

  public Post(@NotNull @Size(max = 100) String postTitle, @NotNull @Size(max = 250) String postDescription, @NotNull String postContent,
              List<Comments> comments, List<Tags> tagsList, Long userID) {
    this.postTitle = postTitle;
    this.postDescription = postDescription;
    this.postContent = postContent;
   // this.comments = comments;
   // this.tagsList = tagsList;
    this.userID = userID;
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

  public String getPostDescription() {
    return postDescription;
  }

  public void setPostDescription(String postDescription) {
    this.postDescription = postDescription;
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

  public Long getUserID() {
    return userID;
  }

  public void setUserID(Long userID) {
    this.userID = userID;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }




}
