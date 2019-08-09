package com.zipcodewilmington.videoproject.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VideoDTOTest {

  private VideoDTO videoDTO = new VideoDTO();

  @Test
  public void getVideoId() {
    Long expected = 123L;
    videoDTO.setVideoId(expected);

    Long actual = videoDTO.getVideoId();

    assertEquals(expected, actual);
  }

  @Test
  public void getVideoName() {
    String expected = "Leroy Jenkins";
    videoDTO.setVideoName(expected);

    String actual = videoDTO.getVideoName();

    assertEquals(expected, actual);
  }

  @Test
  public void getUserId() {
    String expected = "Abramp20";
    videoDTO.setUserId(expected);

    String actual = videoDTO.getUserId();

    assertEquals(expected, actual);
  }

  @Test
  public void getVideoPath() {
    String expected = "truePath";
    videoDTO.setVideoPath(expected);

    String actual = videoDTO.getVideoPath();

    assertEquals(expected, actual);
  }

  @Test
  public void getVideoType() {
    String expected = "bestType";
    videoDTO.setVideoType(expected);

    String actual = videoDTO.getVideoType();

    assertEquals(expected, actual);
  }
}
