package com.zipcodewilmington.videoproject.models;

import java.util.List;

public class VideoComments {
  private int videoId;
  private List<UserComment> comments;

  public int getVideoId() {
    return videoId;
  }

  public void setVideoId(int videoId) {
    this.videoId = videoId;
  }

  public List<UserComment> getComments() {
    return comments;
  }

  public void setComments(List<UserComment> comments) {
    this.comments = comments;
  }


}
