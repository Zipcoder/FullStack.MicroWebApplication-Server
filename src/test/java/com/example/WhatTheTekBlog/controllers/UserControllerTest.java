package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerTest {

    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJpc3MiOiJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVjYjJhYjFkM2QzNmU0MTBlMWIzMDRhNiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTU1NTI5NTU1MiwiZXhwIjoxNTU1MzAyNzUyLCJhenAiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgdmlldzp1c2VycyB2aWV3OnVzZXIifQ.Nqezq6qy1lTq3vAGOZiHlWJflJw0oPwqM9Ngucv1jM4d4jOl_inGGr0EIfeA7jOECq9DicRDEYuu6Stk2dlNaaFfll5wUPDW59O69A5wWyzRUZppr2_gUeCebb7Vtwqd7JVeUc2e_2OXj4Ej4ECnWDBYu7qs9DDBZEnXwPr44zMy8hbcjSla_ejoRr6mQgMVPIKgySl1DgMDFqAIQSrUSucC6eATUTCN-JEH7AeHPyKMJNIaenje4TyfMiLSpJ0CsRJZynyp167QsKqe46tjQJ9m-2Kdxd2OLnyflnaPpjPsfrt_oV8d9JN417pZ8u4sAw7CrARVM2qsRPM43sr4iA";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    @WithMockUser(username = "eleonorbart@gmail.com", password = "Whatthetek!")
    public void testFindById() throws Exception {
        Integer givenId = 1;
        User user = new User();
        user.setId(1);
        user.setName("New User!");
        BDDMockito
                .given(userService.findById(givenId))
                .willReturn(user);

        String expectedContent = "{\"id\":1,\"name\":\"New User!\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/id/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }


    @Test
    @WithMockUser(username = "eleonorbart@gmail.com", password = "Whatthetek!")
    public void testFindAll() throws Exception {
        int givenId = 2;
        User user = new User();
        user.setId(givenId);
        user.setName("testUser");
        User user1 = new User();
        user1.setId(3);
        user1.setName("testUser2");
        userService.create(user);
        userService.create(user1);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        Iterable<User> testUsers = users;
        BDDMockito
                .given(userService.findAllUsers())
                .willReturn(testUsers);

        String expectedContent = "[{\"id\":2,\"name\":\"testUser\"},{\"id\":3,\"name\":\"testUser2\"}]";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testUpdate() throws Exception {
        int givenId = 2;
        User user = new User();
        user.setId(givenId);
        user.setName("testUser");
        BDDMockito.
                given(userService.create(any(User.class)))
                .willReturn(user);

        String input = "{\"id\":123412,\"name\":\"other\",\"email\":\"a;sdlfjk.com\",\"posts\":[],\"comments\":[]}";
        this.mvc.perform(MockMvcRequestBuilders
                .put("/users/" + givenId)
                .content(input)
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPostUser() throws Exception{
        int givenId = 2;
        User user = new User();
        user.setId(givenId);
        user.setName("testUser");
        BDDMockito.
                given(userService.create(any(User.class)))
                .willReturn(user);

        String expectedContent = "{\"id\":2,\"name\":\"testUser\",\"email\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/users/sign-up")
                .content(expectedContent)
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent))
                .andDo(MockMvcResultHandlers.print());
    }

}