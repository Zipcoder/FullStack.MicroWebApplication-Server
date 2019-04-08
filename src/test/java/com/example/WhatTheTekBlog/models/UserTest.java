package com.example.WhatTheTekBlog.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void getId() {
        //Given
        int expected = 1314;
        user.setId(expected);

        //When
        int actual = user.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getIdNull() {
        //Given
        Integer expected = null;
        user.setId(expected);

        //When
        Integer actual = user.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName() {
        //Given
        String expected = "testName";
        user.setName(expected);

        //When
        String actual = user.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameNull() {
        //Given
        String expected = null;
        user.setName(expected);

        //When
        String actual = user.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getEmail() {
        //Given
        String expected = "testEmail@testing.gov";
        user.setEmail(expected);

        //When
        String actual = user.getEmail();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmailNull() {
        //Given
        String expected = null;
        user.setEmail(expected);

        //When
        String actual = user.getEmail();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPosts() {
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());

        user.setPosts(expected);

        //When
        Set<Post> actual = user.getPosts();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getComments() {
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());

        user.setComments(expected);

        //When
        Set<Comments> actual = user.getComments();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
