package com.videolibrary.zipcode.fullstackapp.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private Integer thumbsUp;
    private Integer thumbsDown;

    @Lob
    @Nationalized
    private String content;

    public String getContent() {
        return content;
    }

    public byte[] getDetails() {
        return details;
    }

    @Lob
    private byte[] details;

    public Video() {
    }

    public Video (long id, String title, Integer thumbsUp, Integer thumbsDown) {
        this.id = id;
        this.title = title;
        this.thumbsDown = thumbsDown;
        this.thumbsUp = thumbsUp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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


}
