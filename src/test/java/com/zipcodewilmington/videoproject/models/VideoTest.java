package com.zipcodewilmington.videoproject.models;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VideoTest {
  private Video video = new Video();

  @Test
  public void getVideoId() {
    long expected = 123;
    video.setVideoId(expected);

    long actual = video.getVideoId();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getVideoName() {
    String expected = "Leroy Jenkins";
    video.setVideoName(expected);

    String actual = video.getVideoName();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getUserId() {
    String expected = "Abramp20";
    video.setUserId(expected);

    String actual = video.getUserId();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getVideoPath() {
    String expected = "pathOfLegend";
    video.setVideoPath(expected);

    String actual = video.getVideoPath();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getVideoType() {
    String expected = "mp4";
    video.setVideoType(expected);

    String actual = video.getVideoType();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getVideoSize() {
    long expected = 456;
    video.setVideoSize(expected);

    long actual = video.getVideoSize();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getVideoBytes() {
    byte[] expected = new byte[18];
    video.setVideoBytes(expected);

    byte[] actual = video.getVideoBytes();

    Assert.assertEquals(expected, actual);
  }
}
