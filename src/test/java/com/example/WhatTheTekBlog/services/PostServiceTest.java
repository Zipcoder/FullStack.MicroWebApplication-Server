package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class PostServiceTest {

    @MockBean
    private PostService postService;
    @MockBean
    private TagsRepository mockTagRepo;
    @MockBean
    private TagsService tagsService;
    @MockBean
    private PostRepository mockPostRepo;

    @Before
    public void setup() {
        mockPostRepo = Mockito.mock(PostRepository.class);
        mockTagRepo = Mockito.mock(TagsRepository.class);
        postService = new PostService(mockPostRepo, null);
        tagsService = new TagsService(mockTagRepo, null);
    }

    @Test
    public void createPost() {
        //Given
        Long givenId = 1L;
        Post post = new Post();
        post.setPostID(givenId);
        Post expected = new Post();
        expected.setPostID(givenId);
        //When
        Mockito.when(mockPostRepo.save(post)).thenReturn(expected);
        //Then
        Post actual = postService.createPost(post);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        //Given
        Long givenId1 = 1L;
        Long givenId2 = 2L;
        Post post1 = new Post();
        post1.setPostID(givenId1);
        Post post2 = new Post();
        post2.setPostID(givenId2);
        mockPostRepo.save(post1);
        mockPostRepo.save(post2);
        List<Post> expected = new ArrayList<>();
        expected.add(post1);
        expected.add(post2);
        //When
        Mockito.when(mockPostRepo.findAll()).thenReturn(expected);
        List<Post> actual = (List<Post>) postService.findAll();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByPostId() {
        //Given
        Long givenId = 1L;
        Post expected = new Post();
        expected.setPostID(givenId);
        mockPostRepo.save(expected);
        //When
        Mockito.when(mockPostRepo.findById(givenId)).thenReturn(java.util.Optional.of(expected));
        Optional<Post> actual = postService.findByPostId(givenId);
        //Then
        assertEquals(Optional.of(expected), actual);
    }

    @Test
    public void testUpdate() {
        //Given
        Post post1 = new Post();
        Long givenId = 1000L;
        post1.setPostID(givenId);
        post1.setPostTitle("Post1Title");
        Post expected = new Post();
        expected.setPostID(givenId);
        expected.setPostTitle("Post1TitleUpdated");
        mockPostRepo.save(post1);
        //When
        Mockito.when(mockPostRepo.findById(givenId)).thenReturn(Optional.of(post1));
        postService.updatePost(givenId, expected);
        String actual = postService.findByPostId(givenId).get().getPostTitle();
        //Then
        Assert.assertEquals(post1.getPostTitle(), actual);
    }

    @Test
    public void testDelete() {
        //Given
        Long givenId1 = 1000L;
        Long givenId2 = 2000L;
        Post post1 = new Post();
        post1.setPostID(givenId1);
        Post post2 = new Post();
        post2.setPostID(givenId2);
        mockPostRepo.save(post1);
        mockPostRepo.save(post2);

        List<Post> expected = new ArrayList<>();
        expected.add(post1);
        expected.add(post2);

        Mockito.when(mockPostRepo.findAll()).thenReturn(expected);

        //When
        postService.delete(givenId1);
        //Then
        List<Post> actual = mockPostRepo.findAll();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSaveTags() {
        //Given
        Post post1 = new Post();
        post1.setPostID(1L);
        Post post2 = new Post();
        post2.setPostID(2L);
        Tags tag1 = new Tags();
        tag1.setId(1);
        tag1.setTagName("UnitTest");
        tag1.addPost(post1);
        tag1.addPost(post2);
        Tags tag2 = new Tags();
        tag2.setId(2);
        tag2.setTagName("UnitTest2");
        tag2.addPost(post1);
        mockPostRepo.save(post1);
        mockPostRepo.save(post2);
        mockTagRepo.save(tag1);
        mockTagRepo.save(tag2);

        Set<Post> expectedPostSet = new HashSet<>();
        expectedPostSet.add(post1);
        expectedPostSet.add(post2);
        Set<Tags> tagSet = new HashSet<>();
        tagSet.add(tag1);
        tagSet.add(tag2);
        List<String> tagNames = new ArrayList<>();
        tagNames.add(tag1.getTagName());
        tagNames.add(tag2.getTagName());

        //When
        Mockito.when(mockTagRepo.findById(2)).thenReturn(Optional.of(tag2));
        Mockito.when(mockTagRepo.findById(1)).thenReturn(Optional.of(tag1));
        tag1.setListOfPosts(expectedPostSet);
        tag2.setListOfPosts(expectedPostSet);
        post1.setTagsSet(tagSet);
        post2.setTagsSet(tagSet);
        postService.saveTags(post1);
        postService.saveTags(post2);

        Set<Post> actualPostSet = tagsService.findPostsByTag(tag1.getTagName());
        Assert.assertEquals(expectedPostSet, actualPostSet);
    }

    @Test
    public void testRemoveTags() {
        //Given
        Long givenId1 = 1000L;
        Long givenId2 = 2000L;
        Post post1 = new Post();
        post1.setPostID(givenId1);
        Post post2 = new Post();
        post2.setPostID(givenId2);
        Tags tag1 = new Tags();
        tag1.setId(1);
        tag1.setTagName("UnitTest");
        tag1.addPost(post1);
        tag1.addPost(post2);
        Tags tag2 = new Tags();
        tag2.setId(2);
        tag2.setTagName("UnitTest2");
        tag2.addPost(post1);

        mockPostRepo.save(post1);
        mockPostRepo.save(post2);
        mockTagRepo.save(tag1);
        mockTagRepo.save(tag2);

        Set<Tags> expected = new HashSet<>();
        expected.add(tag1);
        expected.add(tag2);

        //When
        Set<Post> expectedPostSet = new HashSet<>();
        expectedPostSet.add(post1);
        expectedPostSet.add(post2);
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);
        Set<Tags> tagSet = new HashSet<>();
        tagSet.add(tag1);
        tagSet.add(tag2);
        tag1.setListOfPosts(expectedPostSet);
        tag2.setListOfPosts(expectedPostSet);
        post1.setTagsSet(tagSet);
        post2.setTagsSet(tagSet);
        mockPostRepo.save(post1);
        mockTagRepo.save(tag1);
        mockTagRepo.save(tag2);


        Mockito.when(mockTagRepo.findAll()).thenReturn(expected);
        Mockito.when(mockPostRepo.findAll()).thenReturn(postList);

        postService.removeTags(post1);
        mockPostRepo.save(post1);
        mockTagRepo.save(tag1);
        mockTagRepo.save(tag2);

        //Then
        Assert.assertNull(postService.getTags(post1.getPostID()));
        Assert.assertNotNull(postService.getTags(post2.getPostID()));
    }
}
