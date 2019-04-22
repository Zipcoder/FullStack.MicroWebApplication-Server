package com.example.WhatTheTekBlog.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CommentsTest {

    private Comments comments;
    @Before
    public void setUp() throws Exception {
        comments = new Comments();
    }

    @Test
    public void nullaryConstructor() {
        // Given
        // When
        // Then
        Assert.assertNull(comments.getComments());
    }

    @Test
    public void setCommentId() {
        // Given
        Long expected = 10L;
        // When
        comments.setCommentId(expected);
        // Then
        Long actual = comments.getCommentId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setComments() {
        // Given
        String expected = "A test comment";
        // When
        comments.setComments(expected);
        // Then
        String actual = comments.getComments();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUser() {
        // Given
        User expected = new User();
        // When
        comments.setUser(expected);
        // Then
        User actual = comments.getUser();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPost() {
        // Given
        Post expected = new Post();
        // When
        comments.setPost(expected);
        // Then
        Post actual = comments.getPost();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCreatedDate() {
        // Given
        Date expected = new Date();
        // When
        comments.setCreatedDate(expected);
        // Then
        Date actual = comments.getCreatedDate();
        Assert.assertEquals(expected, actual);
    }
}