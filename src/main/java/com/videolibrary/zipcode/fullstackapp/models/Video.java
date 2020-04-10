package com.videolibrary.zipcode.fullstackapp.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//<<<<<<< HEAD
    private long id;
    private String title;
    private Integer thumbsUp;
    private Integer thumbsDown;
    private String url;

    @Lob
    @Nationalized
    private String content;

    @Lob
    private byte[] details;

    public Video() {
    }

    public Video(long id, String title, Integer thumbsUp, Integer thumbsDown) {
        this.id = id;
        this.title = title;
        this.thumbsDown = thumbsDown;
        this.thumbsUp = thumbsUp;
    }
//=======
//    private Long id;
//    private String title;
//    private String url;

//    public Video() {
//    }

    public Video(String title, String content, String url) {
        this.title = title;
        this.url = url;
//>>>>>>> cd7996837b3fc9b8bc6284d43792377a21de5474
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
//<<<<<<< HEAD

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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDetails(byte[] details) {
        this.details = details;
    }

    public byte[] getDetails() {
        return details;
    }
//=======
//>>>>>>> cd7996837b3fc9b8bc6284d43792377a21de5474
}
