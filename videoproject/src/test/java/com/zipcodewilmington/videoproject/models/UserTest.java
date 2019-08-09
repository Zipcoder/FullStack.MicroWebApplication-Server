package com.zipcodewilmington.videoproject.models;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
  private User user = new User();

  @Test
  public void getUserId() {
    String expected = "Abramp20";
    user.setUserId(expected);

    String actual = user.getUserId();

    Assert.assertEquals(expected, actual);


  }

  @Test
  public void getFirstName() {
    String expected = "Abram";
    user.setFirstName(expected);

    String actual = user.getFirstName();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getLastName() {
    String expected = "Phillips";
    user.setLastName(expected);

    String actual = user.getLastName();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getPassword() {
    String expected = "Pa$$w0rd";
    user.setPassword(expected);

    String actual = user.getPassword();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void isLoggedInPositive() {
    boolean expected = true;
    user.setLoggedIn(expected);

    boolean actual = user.isLoggedIn();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void isLoggedInNegative() {
    boolean expected = false;
    user.setLoggedIn(expected);

    boolean actual = user.isLoggedIn();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getLogInTime() {
  }
}
