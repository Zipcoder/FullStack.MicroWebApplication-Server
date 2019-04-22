package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.controllers.TagsController;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class TagsServiceTest {

    @Autowired
    private TagsService tagsService;
    @MockBean
    private TagsRepository mockTagsRepository;

    @Test
    public void createTagsTest() {
        //Given
        String tagName = "ZCW";
        Tags tags = new Tags();
        tags.setTagName(tagName);
        Tags expected= new Tags();
        expected.setTagName(tagName);
        //When
        Mockito.when(mockTagsRepository.save(tags)).thenReturn(expected);
        Tags actual = tagsService.createTags(tags);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createTagsWithSameNameTest() {
        //Given
        String tagName = "ZCW";
        Tags tags = new Tags();
        tags.setTagName(tagName);
        Tags tag2 = new Tags();
        tag2.setTagName(tagName);
        Tags expected= new Tags();
        expected.setTagName(tagName);
        Tags expected2 = new Tags();
        expected2.setTagName(tagName);
        //When
        Mockito.when(mockTagsRepository.save(tags)).thenReturn(expected);
        Mockito.when(mockTagsRepository.save(tag2)).thenThrow(new IllegalArgumentException());
        Tags actual = tagsService.createTags(tags);
        Tags actual2 = tagsService.createTags(tag2);
        //Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void findAllTagsTest() {
        //Given
        String tagName1 = "Ruby";
        String tagName2 = "Yang";
        Tags tags = new Tags();
        tags.setTagName(tagName1);
        Tags tag2 = new Tags();
        tag2.setTagName(tagName2);
        List<Tags> listOfTags = new ArrayList<>();
        listOfTags.add(tags);
        listOfTags.add(tag2);
        Iterable<Tags> expected = listOfTags;
        mockTagsRepository.save(tags);
        mockTagsRepository.save(tag2);
        //When
        Mockito.when(tagsService.findAllTags()).thenReturn(expected);
        Iterable<Tags> actual = tagsService.findAllTags();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findTagsByIdTest() {
        //Given
        String tagName = "Blake";
        String tagName2 = "Weiss";
        Integer tagId = 1;
        Integer tagId2 = 2;
        Tags expected = new Tags();
        expected.setTagName(tagName);
        expected.setId(tagId);
        Tags expected2 = new Tags();
        expected2.setTagName(tagName2);
        expected2.setId(tagId2);
        mockTagsRepository.save(expected);
        mockTagsRepository.save(expected2);
        //When
        Mockito.when(tagsService.findTagById(tagId)).thenReturn(Optional.of(expected));
        Optional<Tags> actual = tagsService.findTagById(tagId);
        Mockito.when(tagsService.findTagById(tagId2)).thenReturn(Optional.of(expected2));
        Optional<Tags> actual2 = tagsService.findTagById(tagId2);
        //Then
        Assert.assertEquals(Optional.of(expected),actual);
        Assert.assertEquals(Optional.of(expected2),actual2);
    }

    @Test
    public void findPostsByTagTest() {
        //Given
        Tags tag = new Tags();
        String tagName = "RWBY";
        tag.setTagName(tagName);
        Integer id = 1;
        tag.setId(id);
        ArrayList<Tags> currentList = new ArrayList<>();
        currentList.add(tag);
        Iterable<Tags> tagList = currentList;
        Set<Post> expected = new HashSet<>();
        Post post1 = new Post();
        post1.setPostTitle("RoosterTooth");
        Post post2 = new Post();
        post2.setPostTitle("YouTube");
        expected.add(post1);
        expected.add(post2);
        tag.setListOfPosts(expected);
        mockTagsRepository.save(tag);
        //When
        Mockito.when(tagsService.findAllTags()).thenReturn(tagList);
        Set<Post> actual = tagsService.findPostsByTag(tagName);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findFilteredPostsByTagTest() {
        //Given
        Tags tag = new Tags();
        String tagName = "RWBY";
        tag.setTagName(tagName);
        Integer id = 1;
        tag.setId(id);
        Set<Post> tag1Post = new HashSet<>();
        Post post1 = new Post();
        post1.setPostTitle("RoosterTooth");
        Post post2 = new Post();
        tag1Post.add(post1);
        tag1Post.add(post2);
        post2.setPostTitle("YouTube");
        tag.setListOfPosts(tag1Post);
        Tags tag2 = new Tags();
        String tagName2 = "Avengers";
        tag2.setTagName(tagName2);
        Integer id2 = 2;
        tag2.setId(id2);
        Set<Post> tag2Post = new HashSet<>();
        Post post3 = new Post();
        post1.setPostTitle("End Game");
        tag2Post.add(post2);
        tag2Post.add(post3);
        tag2.setListOfPosts(tag2Post);
        Set<Post> expected = new HashSet<>();
        expected.add(post2);
        List<String> filteredTags = new ArrayList<>();
        filteredTags.add(tag.getTagName());
        filteredTags.add(tag2.getTagName());
        mockTagsRepository.save(tag);
        mockTagsRepository.save(tag2);
        //When
        Mockito.when(mockTagsRepository.findByTagName(tagName)).thenReturn(tag);
        Mockito.when(mockTagsRepository.findByTagName(tagName2)).thenReturn(tag2);
        Set<Post> actual = tagsService.findFilteredPostsByTag(filteredTags);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateTest() {
        //Given
        Tags tag = new Tags();
        tag.setId(1);
        tag.setTagName("Stark");
        Tags expected = new Tags();
        expected.setId(2);
        expected.setTagName("Iron Man");
        mockTagsRepository.save(tag);
        //When
        Mockito.when(mockTagsRepository.findById(1)).thenReturn(Optional.of(tag));
        tagsService.update(1,expected);
        String actual = tagsService.findTagById(1).get().getTagName();
        //Then
        Assert.assertEquals("Iron Man",actual);
    }

    @Test
    public void deleteTagsById() {
        //Given
        Tags tag = new Tags();
        String tagName = "Android";
        tag.setTagName(tagName);
        Mockito.when(mockTagsRepository.findByTagName(tagName)).thenReturn(tag);
        //When
        Boolean actuallyDeleted = tagsService.deleteTags(tagName);
        //Then
        Assert.assertTrue(actuallyDeleted);
    }
}
