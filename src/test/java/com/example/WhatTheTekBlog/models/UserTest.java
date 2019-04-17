package com.example.WhatTheTekBlog.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
    public void getEmail() {
        //Given
        String expected = "testEmail@testing.gov";
        user.setName(expected);

        //When
        String actual = user.getName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmailNull() {
        //Given
        String expected = null;
        user.setName(expected);

        //When
        String actual = user.getName();

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

    @Test
    public void setId() {
        //Given
        int expected = 1235678;
        user.setId(expected);

        //When
        int actual = user.getId();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPostTest() {
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());

        user.setPosts(expected);
        Post newPost = new Post();

        //When
        user.addPost(newPost);
        //Then
        expected.add(newPost);
        Set<Post> actual = user.getPosts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCommentTest() {
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());

        user.setComments(expected);
        Comments newComments = new Comments();

        //When
        user.addComment(newComments);
        //Then
        expected.add(newComments);
        Set<Comments> actual = user.getComments();
        Assert.assertEquals(expected, actual);
    }

}