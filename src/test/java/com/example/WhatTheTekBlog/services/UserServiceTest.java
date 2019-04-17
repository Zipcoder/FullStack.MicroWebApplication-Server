package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.controllers.UserController;
import com.example.WhatTheTekBlog.models.User;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class UserServiceTest {

        @MockBean
        private UserService service;

        private UserController controller;

        @Before
        public void setup(){
            this.controller = new UserController(userService);
            mockRepo = Mockito.mock(UserRepository.class);
            userService = new UserService(mockRepo);
        }


    @Test
    public void testDelete() {
        // Given
        User user = new User();
        user.setId(1);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito
                .given(service.create(user))
                .willReturn(user);
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
        User user = new User();
        user.setId(1);
        User expected = new User();
        expected.setId(1);
        //When
        Mockito.when(mockRepo.save(user)).thenReturn(expected);

        //Then
        User actual = userService.create(user);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindById(){
        //Given
        User expected = new User();
        expected.setId(1);
        mockRepo.save(expected);
        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(java.util.Optional.of(expected));
        User actual = userService.findById(1);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByName(){
        //Given
        String testName = "expected";
        User expected = new User();
        expected.setId(1);
        expected.setName(testName);
        mockRepo.save(expected);
        //When
        Mockito.when(mockRepo.findByName(testName)).thenReturn(Optional.of(expected));
        User actual = userService.findByName(testName);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindByIdError(){
        //Given
        User expected = new User();
        expected.setId(1);
        mockRepo.save(expected);
        //When
        User actual = userService.findById(1234567);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteService(){
        //Given
        User user = new User();
        user.setId(1);
        User user1 = new User();
        user1.setId(2);
        mockRepo.save(user);
        mockRepo.save(user1);

        List<User> expected = new ArrayList<>();
        expected.add(user);
        expected.add(user1);

        Mockito.when(mockRepo.findAll()).thenReturn(expected);

        //When
        userService.delete(1);
        //Then
        Mockito.verify(mockRepo, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testFindAllService(){
        //Given
        User user = new User();
        user.setId(1);
        User user1 = new User();
        user1.setId(2);
        mockRepo.save(user);
        mockRepo.save(user1);

        List<User> expected = new ArrayList<>();
        expected.add(user);
        expected.add(user1);
        //When
        Mockito.when(mockRepo.findAll()).thenReturn(expected);
        List<User> actual = (List<User>) userService.findAllUsers();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testgetPostsByUser(){
        //Given
        Set<Post> expected = new HashSet<>();
        expected.add(new Post());
        expected.add(new Post());
        User user = new User();
        user.setId(1);
        user.setPosts(expected);

        mockRepo.save(user);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(user));
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
        User user = new User();
        user.setId(1);
        user.setComments(expected);

        mockRepo.save(user);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(user));
        Set<Comments> actual = (Set<Comments>) userService.getCommentsByUser(1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateService(){
        //Given
        User user = new User();
        user.setId(1);
        user.setName("testing");
        User expected = new User();
        expected.setId(2);
        expected.setName("expected");
        mockRepo.save(user);

        //When
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(user));
        userService.update(1, expected);
        String actual = userService.findById(1).getName();

        //Then
        Assert.assertEquals("expected", actual);
    }
}
