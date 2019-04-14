package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sun.rmi.runtime.Log;

import java.util.*;

import static org.junit.Assert.*;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostRepository repository;
    private UserRepository userRepository;

    @Test
    public void testFindAll() throws Exception {
        Long givenId = 200L;
        List<Comments> commentsList = new ArrayList<>();
        Set<Tags> tagsSet = new HashSet<>();
        User author1 = new User();
        author1.setId(200);
        author1.setName("author1");

        Post post = new Post();
        post.setPostID(givenId);
        post.setPostContent("Post1Content");
        post.setPostTitle("Post1Title");
        post.setPostSummary("Post1Summary");
        post.setCreator(author1);
        post.setCreatedDate(new Date());
      //  post.setComments(commentsList);
       // post.setTagsSet(tagsSet);

        BDDMockito
                .given(repository.findById(1L))
                .willReturn(Optional.of(post));

        String expectedContent = "{\"postID\":null,\"postTitle\":\"Post1Title\"," +
                "\"postSummary\":Post1Summary,\"postContent\":Post1Content," +
                "\"comments\":null,\"tagsList\":null,\"user\":\"author1\"}";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/posts/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetPost() {
    }

    @Test
    public void testCreatePost() {
    }

    @Test
    public void testUpdatePost() {
    }

    @Test
    public void testDeletePost() {
    }
}
