package com.zipcodewilmington.videoproject.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserJsonTest {

  private UserJson userJson = new UserJson();

  @Test
  public void getUserId() {
    String expected = "Abramp20";
    userJson.setUserId(expected);

    String actual = userJson.getUserId();

    Assert.assertEquals(expected, actual);


  }

  @Test
  public void getFirstName() {
    String expected = "Abram";
    userJson.setFirstName(expected);

    String actual = userJson.getFirstName();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getLastName() {
    String expected = "Phillips";
    userJson.setLastName(expected);

    String actual = userJson.getLastName();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void getPassword() {
    String expected = "Pa$$w0rd";
    userJson.setPassword(expected);

    String actual = userJson.getPassword();

    Assert.assertEquals(expected, actual);
  }
}
