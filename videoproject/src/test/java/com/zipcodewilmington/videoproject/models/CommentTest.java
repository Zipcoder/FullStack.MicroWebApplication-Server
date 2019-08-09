package com.zipcodewilmington.videoproject.models;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Date;

import static org.junit.Assert.*;

public class CommentTest {
  private Comment comment = new Comment();

  @Test
  public void getCommentId() {
    //Given
    int expected = 1234;
    //when
    comment.setCommentId(1234);
    int actual = comment.getCommentId();
    //Then
    assertEquals(expected,actual);
  }

  @Test
  public void getCommentText() {
    //Given
    String expected = "Hello";
    //when
    comment.setCommentText("Hello");
    String actual = comment.getCommentText();
    //Then
    assertEquals(expected,actual);
  }

  @Test
  public void getVideoId() {
    //Given
    int expected = 1234;
    //when
    comment.setVideoId(1234);
    int actual = comment.getVideoId();
    //Then
    assertEquals(expected,actual);
  }

  @Test
  public void getUserId() {
    //Given
    String expected = "Abramp20";
    //when
    comment.setUserId("Abramp20");
    String actual = comment.getUserId();
    //Then
    assertEquals(expected,actual);
  }

  /*  @Test
    public void getCreateDate() {
        //Given
        String expected = ("2009-12-31");
        //when
        comment.setCreateDate();
        String actual = comment.getCreateDate().toString();
        //Then
        assertEquals(expected,actual);
    }
    */
}
