package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TagsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    TagsRepository tagsRepository;

    @Before
    public void setUp() {
        Tags tag = new Tags();
        tag.setId(1);
        tag.setTagName("Avengers");
        Set<Post> postByTags = new HashSet<>();
        Post post1 = new Post();
        post1.setPostID(1l);
        post1.setPostTitle("Civil War");
        Post post2 = new Post();
        post2.setPostID(2l);
        post2.setPostTitle("Infinity War");
        postByTags.add(post1);
        postByTags.add(post2);
        tag.setListOfPosts(postByTags);
    }

    @Test
    public void createTest() {

    }
}
