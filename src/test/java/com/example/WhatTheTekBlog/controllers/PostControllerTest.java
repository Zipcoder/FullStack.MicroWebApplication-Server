package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
    public void testGetPost() throws Exception {
        Long givenId = 1L;
        Comments comments = new Comments();
        Tags tags = new Tags();
        tags.setTagName("tag1");
        comments.setComments("comment1");
        Set<Comments> commentsList = new HashSet<>();
        Set<Tags> tagsSet = new HashSet<>();
        User author1 = new User();
        author1.setId(1);
        author1.setName("author1");

        Post post = new Post();
        post.setPostID(givenId);
        post.setPostContent("Post1Content");
        post.setPostTitle("Post1Title");
        post.setPostSummary("Post1Summary");
        post.setCreator(author1);
        post.setCreatedDate(new Date());
        comments.setUser(author1);
        comments.setPost(post);
        tags.setId(1);
        post.setComments(commentsList);
        post.setTagsSet(tagsSet);
        post.setPostID(1L);

        BDDMockito
                .given(repository.findById(1L))
                .willReturn(Optional.of(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\"," +
                "\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-14\"," +
                "\"comments\":[],\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\",\"email\":null}}";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/post/"+givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreatePost() throws Exception {
        Long givenId = 1L;
        Comments comments = new Comments();
        Tags tags = new Tags();
        tags.setTagName("tag1");
        comments.setComments("comment1");
        Set<Comments> commentsList = new HashSet<>();
        Set<Tags> tagsSet = new HashSet<>();
        User author1 = new User();
        author1.setId(1);
        author1.setName("author1");

        Post post = new Post();
        post.setPostID(givenId);
        post.setPostContent("Post1Content");
        post.setPostTitle("Post1Title");
        post.setPostSummary("Post1Summary");
        post.setCreator(author1);
        post.setCreatedDate(new Date());
        comments.setUser(author1);
        comments.setPost(post);
        tags.setId(1);
        post.setComments(commentsList);
        post.setTagsSet(tagsSet);
        post.setPostID(1L);

        BDDMockito
                .given(repository.save(post))
                .willReturn(post);

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\"," +
                "\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-14\"," +
                "\"comments\":[],\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\",\"email\":null}}";

        this.mvc.perform(MockMvcRequestBuilders
                .post("/users/createPost/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(expectedContent)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated());
            //    .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }


    @Test
    public void testUpdatePost() {

    }

    @Test
    public void testDeletePost() {
    }
}
