package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import com.example.WhatTheTekBlog.services.PostService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.Before;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sun.rmi.runtime.Log;

import java.util.*;

import static org.junit.Assert.*;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PostControllerTest {

   private Long givenId = 1L;
   private Set<Comments> commentsList = new HashSet<>();
   private Set<Tags> tagsSet = new HashSet<>();
   private Post post = new Post();
    private String token; //= "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJpc3MiOiJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVjYjJhYjFkM2QzNmU0MTBlMWIzMDRhNiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTU1NTI5NTU1MiwiZXhwIjoxNTU1MzAyNzUyLCJhenAiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgdmlldzp1c2VycyB2aWV3OnVzZXIifQ.Nqezq6qy1lTq3vAGOZiHlWJflJw0oPwqM9Ngucv1jM4d4jOl_inGGr0EIfeA7jOECq9DicRDEYuu6Stk2dlNaaFfll5wUPDW59O69A5wWyzRUZppr2_gUeCebb7Vtwqd7JVeUc2e_2OXj4Ej4ECnWDBYu7qs9DDBZEnXwPr44zMy8hbcjSla_ejoRr6mQgMVPIKgySl1DgMDFqAIQSrUSucC6eATUTCN-JEH7AeHPyKMJNIaenje4TyfMiLSpJ0CsRJZynyp167QsKqe46tjQJ9m-2Kdxd2OLnyflnaPpjPsfrt_oV8d9JN417pZ8u4sAw7CrARVM2qsRPM43sr4iA";

    @Before
    public void setup() {

        Comments comments = new Comments();
        Tags tags = new Tags();
        tags.setTagName("tag1");
        comments.setComments("comment1");
        User author1 = new User();
        author1.setId(1);
        author1.setName("author1");

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
        post.setPostID(givenId);
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    @Test
    public void testGetPost() throws Exception {
        BDDMockito
                .given(postService.findByPostId(1L))
                .willReturn(Optional.ofNullable(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-15\",\"comments\":[]," +
                "\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\"}}";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/post/"+givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreatePost() throws Exception {
        BDDMockito
                .given(postService.createPost(post))
                .willReturn(post);

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\"," +
                "\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-14\"," +
                "\"comments\":[],\"tagsSet\":[],\"creator\":{null},eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJuaWNrbmFtZSI6ImVsZW9ub3JiYXJ0IiwibmFtZSI6ImVsZW9ub3JiYXJ0QGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci81MDk2MjczNDM3ZThjOGFjOTIwMTAwYTE5NDM1YzY2Yz9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmVsLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDE5LTA0LTE0VDAzOjM5OjQyLjQ0NFoiLCJpc3MiOiJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVjYjJhYjFkM2QzNmU0MTBlMWIzMDRhNiIsImF1ZCI6InY2T01oTm1OME9PM2FQUW5DOVZuRUFDQkRYN0NPUjBOIiwiaWF0IjoxNTU1MzY1NTI3LCJleHAiOjE1NTU0MDE1MjcsImF0X2hhc2giOiJHNzdsa1Q5cXE5TDh5NnFMUFo5SXJBIiwibm9uY2UiOiJZNmxaUmdUd0RtMGE0ejV4UUJLd2hhZkE5eDdCNjJScCJ9.h_FYlFmckr4lpQD-fc7Uh8y2Omal474qm1G3x4egTnCVSj35pOlgMXyI30IIgQN2A1-zXWAi9SDrC4CrofK1ahiNB1Ac3aIs0EBoO91TVcKJe03TKI2QE2zcIa46grXJld84DjNPgZkYy-HJGBYc-vScagO3YlJ_bX8TGEUoyt-BIUeobIfyauqOzyLomYpDP1soIeuvg_Fe8_Mk2iCVXlxSNJHaYEfC9SGg2m7XqolBhzNNC3eSCfqK8OFPm4v7n_fqojMJ9NXlE73S-dxM8ybE_08xCp0X3jJOY2S4mywGijprX0R9gMUlcbLoBRYdH0oRHA5k7jeoIqk3BFrpog}";

        this.mvc.perform(MockMvcRequestBuilders
                .post("/users/createPost/")
                .content(expectedContent)
                //.header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testUpdatePost() throws Exception {
        BDDMockito
                .given(postService.findByPostId(1L))
                .willReturn(Optional.ofNullable(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-15\",\"comments\":[],\"tagsSet\":[]," +
                "\"creator\":{\"id\":1,\"name\":\"author1\"}}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("users/updatePost/"+givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void testDeletePost() throws Exception {
        BDDMockito
                .given(postService.findByPostId(1L))
                .willReturn(Optional.ofNullable(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-15\",\"comments\":[],\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\"}}";
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/users/deletePost"+givenId)
                .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
