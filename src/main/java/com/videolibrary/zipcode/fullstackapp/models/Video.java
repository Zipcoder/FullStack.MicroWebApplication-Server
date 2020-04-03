package com.videolibrary.zipcode.fullstackapp.models;

import com.videolibrary.zipcode.fullstackapp.HashTag;
import com.videolibrary.zipcode.fullstackapp.Publisher;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private List<Comment> comments;
    private String title;
   // private Publisher accountInfo;
    private Integer thumbsUp;
    private Integer thumbsDown;
   //private List<HashTag> hashTags;

    @Lob
    @Nationalized
    private String content;

    @Lob
    private byte[] details;

    public Video() {
    }

    public Video (Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getDetails() {
        return details;
    }

    public void setDetails(byte[] details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Publisher getAccountInfo() {
//        return accountInfo;
//    }
//
//    public void setAccountInfo(Publisher accountInfo) {
//        this.accountInfo = accountInfo;
//    }

    public Integer getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Integer thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public Integer getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(Integer thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

//    public List<HashTag> getHashTags() {
//        return hashTags;
//    }
//
//    public void setHashTags(List<HashTag> hashTags) {
//        this.hashTags = hashTags;
//    }





}
