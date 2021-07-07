package com.theocho.youflix.models;


import javax.persistence.*;

@Entity
//@Table(name ="videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String videoEtag;
    private String fileName;
    private String videoURL;
    private String thumbnailURL;

    public Video(){

    }

    public Video(String videoEtag, String fileName, String videoURL, String thumbnailURL){
        this.videoEtag = videoEtag;
        this.fileName = fileName;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoEtag() {
        return videoEtag;
    }

    public void setVideoEtag(String videoEtag) {
        this.videoEtag = videoEtag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String url) {
        this.videoURL = url;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
