package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.controllers.UserController;
import com.example.WhatTheTekBlog.models.AppUser;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class AppUserServiceTest {

        @MockBean
        private UserService service;

        private UserController controller;

        @Before
        public void setup(){
            this.controller = new UserController(userService, new BCryptPasswordEncoder());
            mockRepo = Mockito.mock(UserRepository.class);
            userService = new UserService(mockRepo);
        }


    @Test
    public void testDelete() {
        // Given
        AppUser appUser = new AppUser();
        appUser.setId(1);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito
                .given(service.create(appUser))
                .willReturn(appUser);
        BDDMockito.
                given(service.delete(1))
                .willReturn(true);

        // When
        ResponseEntity<Boolean> response = controller.delete(1);
        HttpStatus actual = response.getStatusCode();
        Boolean actualDeleted = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(actualDeleted);
    }


    @Mock
    private UserRepository mockRepo;
    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateService(){
        //Given
        AppUser appUser = new AppUser();
        appUser.setId(1);
        AppUser expected = new AppUser();
        expected.setId(1);
        //When
        Mockito.when(mockRepo.save(appUser)).thenReturn(expected);

        //Then
        AppUser actual = userService.create(appUser);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindById(){
        //Given
        AppUser expected = new AppUser();
        expected.setId(1);
        mockRepo.save(expected);
        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(java.util.Optional.of(expected));
        AppUser actual = userService.findById(1);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByName(){
        //Given
        String testName = "expected";
        AppUser expected = new AppUser();
        expected.setId(1);
        expected.setName(testName);
        mockRepo.save(expected);
        //When
        Mockito.when(mockRepo.findByName(testName)).thenReturn(expected);
        AppUser actual = userService.findByName(testName);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindByIdError(){
        //Given
        AppUser expected = new AppUser();
        expected.setId(1);
        mockRepo.save(expected);
        //When
        AppUser actual = userService.findById(1234567);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteService(){
        //Given
        AppUser appUser = new AppUser();
        appUser.setId(1);
        AppUser appUser1 = new AppUser();
        appUser1.setId(2);
        mockRepo.save(appUser);
        mockRepo.save(appUser1);

        List<AppUser> expected = new ArrayList<>();
        expected.add(appUser);
        expected.add(appUser1);

        Mockito.when(mockRepo.findAll()).thenReturn(expected);

        //When
        userService.delete(1);
        //Then
        Mockito.verify(mockRepo, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testFindAllService(){
        //Given
        AppUser appUser = new AppUser();
        appUser.setId(1);
        AppUser appUser1 = new AppUser();
        appUser1.setId(2);
        mockRepo.save(appUser);
        mockRepo.save(appUser1);

        List<AppUser> expected = new ArrayList<>();
        expected.add(appUser);
        expected.add(appUser1);
        //When
        Mockito.when(mockRepo.findAll()).thenReturn(expected);
        List<AppUser> actual = (List<AppUser>) userService.findAllUsers();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testgetPostsByUser(){
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setPosts(expected);

        mockRepo.save(appUser);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(appUser));
        Set<Post> actual = (Set<Post>) userService.getPostsByUser(1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testgetCommentsByUser(){
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setComments(expected);

        mockRepo.save(appUser);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(appUser));
        Set<Comments> actual = (Set<Comments>) userService.getCommentsByUser(1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateService(){
        //Given
        AppUser appUser = new AppUser();
        appUser.setId(1);
        appUser.setName("testing");
        AppUser expected = new AppUser();
        expected.setId(2);
        expected.setName("expected");
        mockRepo.save(appUser);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(appUser));
        userService.update(1, expected);
        String actual = userService.findById(1).getName();

        //Then
        Assert.assertEquals("expected", actual);
    }
}