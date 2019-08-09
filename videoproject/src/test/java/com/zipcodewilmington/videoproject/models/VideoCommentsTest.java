package com.zipcodewilmington.videoproject.models;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VideoCommentsTest {
  private VideoComments videoComments = new VideoComments();
  UserComment userComment = new UserComment();
  @Test
  public void getVideoId() {
    //Given
    int expected = 1234;
    //when
    videoComments.setVideoId(1234);
    int actual = videoComments.getVideoId();
    //Then
    assertEquals(expected,actual);
  }

  @Test
  public void getComments() {
    //Given
    UserComment firstComment = new UserComment();
    UserComment secondComment = new UserComment();

    List<UserComment> expected = Arrays.asList(firstComment,secondComment);

    videoComments.setComments(expected);

    List<UserComment> actual = videoComments.getComments();
    //Then
    assertEquals(expected,actual);
  }
}
