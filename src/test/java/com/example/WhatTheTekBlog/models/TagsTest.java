package com.example.WhatTheTekBlog.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TagsTest {

    private Tags tag;

    @Before
    public void setUp() {
        tag = new Tags();
    }

    @Test
    public void getIdTest() {
        //Given
        Integer expected = null;
        //When
        Integer actual = tag.getId();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setIdTest() {
        //Given
        Integer expected = 1;
        //When
        tag.setId(1);
        Integer actual = tag.getId();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTagNameTest() {
        //Given
        String expected = null;
        //When
        String actual = tag.getTagName();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTagNameTest() {
        //Given
        String expected = "Google";
        //When
        tag.setTagName("Google");
        String actual = tag.getTagName();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getListOfPosts() {
        //Given
        Set<Post> expected = new HashSet<>();
        //When
        Set<Post> actual = tag.getListOfPosts();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setListOfPosts() {
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());
        //When
        tag.setListOfPosts(expected);
        Set<Post> actual = tag.getListOfPosts();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addPostTest() {
        //Given
        Set<Post> expected = new HashSet<>();
        Post post = new Post();
        expected.add(post);
        //When
        tag.addPost(post);
        Set<Post> actual = tag.getListOfPosts();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        //Given
        int id = 1;
        String tagName = "One Piece";
        tag.setId(id);
        tag.setTagName(tagName);
        String expected = "Tags{id=1, tagName='One Piece'}";
        //When
        String actual = tag.toString();
        //Then
        Assert.assertEquals(expected,actual);

    }

}
