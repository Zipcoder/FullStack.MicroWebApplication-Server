package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.UserRepository;
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

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository repository;

    @Test
    public void testSFindById() throws Exception {
        Integer givenId = 1;
        User user = new User();
        user.setId(1);
        user.setName("New User!");
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(user));

        String expectedContent = "{\"id\":1,\"name\":\"New User!\",\"email\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

}