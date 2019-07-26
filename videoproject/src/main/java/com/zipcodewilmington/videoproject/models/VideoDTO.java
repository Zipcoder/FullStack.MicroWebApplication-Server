package com.zipcodewilmington.videoproject.models;

public class VideoDTO {

  private Long videoId;
  private String videoName;
  private String userId;
  private String videoPath;
  private String videoType;


  public VideoDTO(Number videoId, String videoName, String userId, String videoPath, String videoType) {
    this.videoId = videoId.longValue();
    this.videoName = videoName;
    this.userId = userId;
    this.videoPath = videoPath;
    this.videoType = videoType;
  }

  public Long getVideoId() {
    return videoId;
  }

  public void setVideoId(Long videoId) {
    this.videoId = videoId;
  }

  public String getVideoName() {
    return videoName;
  }

  public void setVideoName(String videoName) {
    this.videoName = videoName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getVideoPath() {
    return videoPath;
  }

  public void setVideoPath(String videoPath) {
    this.videoPath = videoPath;
  }

  public String getVideoType() {
    return videoType;
  }

  public void setVideoType(String videoType) {
    this.videoType = videoType;
  }

}
