package com.zipcodewilmington.videoproject.models;


import org.junit.Test;

import static org.junit.Assert.*;

public class UserCommentTest {
  UserComment userComment = new UserComment();

  /*  @Test
    public void getCreatedDate() {
    }
*/
  @Test
  public void getUserId() {
    //Given
    String expected = "Abramp20";
    //when
    userComment.setUserId("Abramp20");
    String actual = userComment.getUserId();
    //Then
    assertEquals(expected,actual);
  }

  @Test
  public void getText() {
    //Given
    String expected = "Abram is so cool!";
    //when
    userComment.setText("Abram is so cool!");
    String actual = userComment.getText();
    //Then
    assertEquals(expected,actual);
  }
}
