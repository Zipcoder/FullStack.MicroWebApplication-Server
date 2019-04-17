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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PostControllerTest {

    private Long givenId = 1L;
    private Set<Comments> commentsList = new HashSet<>();
    private Set<Tags> tagsSet = new HashSet<>();
    private Post post = new Post();
    private String token; //= "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJpc3MiOiJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVjYjJhYjFkM2QzNmU0MTBlMWIzMDRhNiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTU1NTI5NTU1MiwiZXhwIjoxNTU1MzAyNzUyLCJhenAiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgdmlldzp1c2VycyB2aWV3OnVzZXIifQ.Nqezq6qy1lTq3vAGOZiHlWJflJw0oPwqM9Ngucv1jM4d4jOl_inGGr0EIfeA7jOECq9DicRDEYuu6Stk2dlNaaFfll5wUPDW59O69A5wWyzRUZppr2_gUeCebb7Vtwqd7JVeUc2e_2OXj4Ej4ECnWDBYu7qs9DDBZEnXwPr44zMy8hbcjSla_ejoRr6mQgMVPIKgySl1DgMDFqAIQSrUSucC6eATUTCN-JEH7AeHPyKMJNIaenje4TyfMiLSpJ0CsRJZynyp167QsKqe46tjQJ9m-2Kdxd2OLnyflnaPpjPsfrt_oV8d9JN417pZ8u4sAw7CrARVM2qsRPM43sr4iA";

    public PostControllerTest() throws ParseException {
    }

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
    private PostRepository repository;

    @Test
    public void testGetPost() throws Exception {
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-16\",\"comments\":[]," +
                "\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\"}}";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/post/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreatePost() throws Exception {
        BDDMockito
                .given(repository.save(post))
                .willReturn(post);

        String expectedContent = "{\"postID\":null,\"postTitle\":\"Post1Title\"," +
                "\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-14\"," +
                "\"comments\":[],\"tagsSet\":[],\"creator\":{null}";

        this.mvc.perform(MockMvcRequestBuilders
                .post("/users/createPost/eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJuaWNrbmFtZSI6InRlc3QiLCJuYW1lIjoidGVzdEBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvMWFlZGI4ZDlkYzQ3NTFlMjI5YTMzNWUzNzFkYjgwNTg_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZ0ZS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAxOS0wNC0xNVQxMzo0MzoyNi40MzVaIiwiaXNzIjoiaHR0cHM6Ly93aGF0dGhldGVrLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1Y2I0OGE3ZTAyMGY4NzEwNDI5NzViNGUiLCJhdWQiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsImlhdCI6MTU1NTQzNzkwNCwiZXhwIjoxNTU1NDczOTA0LCJhdF9oYXNoIjoiT0dkQ253TFJBQXVYOUZMYmZIbVV6USIsIm5vbmNlIjoiQVlEWm8wbEhYY05ueUlSSlhqWENjbTRtcjdJUTd0WFAifQ.hOkl-7VPrHQUO0tO7B8Wm-l9Wyx_ekYy5oHdSK4HO2DCsbdVXMIxfgaP_Ch_61bf8Df7nT2xnq4ku5636bhuAEUGX-GMkVVxxrDnb5izhW8kkKcT5yhK1F6Lh97FR9ego6Kl081yLqbHD42zvZQ9HJWHEbQ4BC3GqhrYUjxozK_LsODSPjwX4ldDFUV-pu4nZnW4YQSY4v9twyVg-BdZEk5TpWVR_bngXIFEtVYiINzRp2ygwKlcnv3dYeV-R9rrHsYrUPoYXlYrUNb5uBu2rp-fkMMToL9Ca8i6KHVlxxZ-6CYt2WfT-YHhaV9jgNrSCT6wq9DG3wuWDW-dJdttVg")
                .content(expectedContent)
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
                .given(repository.findById(givenId))
                .willReturn(Optional.of(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-15\",\"comments\":[],\"tagsSet\":[]," +
                "\"creator\":{\"id\":1,\"name\":\"author1\"}}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/updatePost/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void testDeletePost() throws Exception {
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(post));

        String expectedContent = "{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\"," +
                "\"postContent\":\"Post1Content\"," +
                "\"createdDate\":\"2019-04-15\",\"comments\":[],\"tagsSet\":[],\"creator\":{\"id\":1,\"name\":\"author1\"}}";
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/users/deletePost/" + givenId)
                .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
