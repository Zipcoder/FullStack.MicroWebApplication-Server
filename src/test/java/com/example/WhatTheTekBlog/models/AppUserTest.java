package com.example.WhatTheTekBlog.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AppUserTest {

    private AppUser appUser;
    @Before
    public void setUp() {
        appUser = new AppUser();
    }

    @Test
    public void getId() {
        //Given
        int expected = 1314;
        appUser.setId(expected);

        //When
        int actual = appUser.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getIdNull() {
        //Given
        Integer expected = null;
        appUser.setId(expected);

        //When
        Integer actual = appUser.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName() {
        //Given
        String expected = "testName";
        appUser.setName(expected);

        //When
        String actual = appUser.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameNull() {
        //Given
        String expected = null;
        appUser.setName(expected);

        //When
        String actual = appUser.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getEmail() {
        //Given
        String expected = "testEmail@testing.gov";
        appUser.setEmail(expected);

        //When
        String actual = appUser.getEmail();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmailNull() {
        //Given
        String expected = null;
        appUser.setEmail(expected);

        //When
        String actual = appUser.getEmail();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPosts() {
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());

        appUser.setPosts(expected);

        //When
        Set<Post> actual = appUser.getPosts();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getComments() {
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());

        appUser.setComments(expected);

        //When
        Set<Comments> actual = appUser.getComments();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        //Given
        int expected = 1235678;
        appUser.setId(expected);

        //When
        int actual = appUser.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPostTest() {
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());

        appUser.setPosts(expected);
        Post newPost = new Post();

        //When
        appUser.addPost(newPost);
        //Then
        expected.add(newPost);
        Set<Post> actual = appUser.getPosts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCommentTest() {
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());

        appUser.setComments(expected);
        Comments newComments = new Comments();

        //When
        appUser.addComment(newComments);
        //Then
        expected.add(newComments);
        Set<Comments> actual = appUser.getComments();
        Assert.assertEquals(expected, actual);
    }

}