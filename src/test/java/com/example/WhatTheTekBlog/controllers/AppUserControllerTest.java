package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.AppUser;
import com.example.WhatTheTekBlog.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class AppUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    @WithMockUser(username = "eleonorbart@gmail.com", password = "Whatthetek!")
    public void testFindById() throws Exception {
        Integer givenId = 1;
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setName("New AppUser!");
        BDDMockito
                .given(userService.findById(givenId))
                .willReturn(appUser);

        String expectedContent = "{\"id\":1,\"name\":\"New AppUser!\",\"email\":null,\"password\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/users/id/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }


    @Test
    @WithMockUser(username = "eleonorbart@gmail.com", password = "Whatthetek!")
    public void testFindAll() throws Exception {
        int givenId = 2;
        AppUser appUser = new AppUser();
        appUser.setId(givenId);
        appUser.setName("testUser");
        AppUser appUser1 = new AppUser();
        appUser1.setId(3);
        appUser1.setName("testUser2");
        userService.create(appUser);
        userService.create(appUser1);
        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(appUser);
        appUsers.add(appUser1);
        Iterable<AppUser> testUsers = appUsers;
        BDDMockito
                .given(userService.findAllUsers())
                .willReturn(testUsers);

        String expectedContent = "[{\"id\":2,\"name\":\"testUser\",\"email\":null},{\"id\":3,\"name\":\"testUser2\",\"email\":null}]";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/appUsers/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testUpdate() throws Exception {
        int givenId = 2;
        AppUser appUser = new AppUser();
        appUser.setId(givenId);
        appUser.setName("testUser");
        BDDMockito.
                given(userService.create(any(AppUser.class)))
                .willReturn(appUser);

        String input = "{\"id\":123412,\"name\":\"other\",\"email\":\"a;sdlfjk.com\",\"posts\":[],\"comments\":[]}";
        this.mvc.perform(MockMvcRequestBuilders
                .put("/users/" + givenId)
                .content(input)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPostUser() throws Exception{
        int givenId = 2;
        AppUser appUser = new AppUser();
        appUser.setId(givenId);
        appUser.setName("testUser");
        BDDMockito.
                given(userService.create(any(AppUser.class)))
                .willReturn(appUser);

        String expectedContent = "{\"id\":2,\"name\":\"testUser\",\"email\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/users/sign-up")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent))
                .andDo(MockMvcResultHandlers.print());
    }

}