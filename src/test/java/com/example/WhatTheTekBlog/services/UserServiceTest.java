package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.controllers.UserController;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
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
            this.controller = new UserController(service);
        }


        @Test
        public void testCreate() {
            // Given
            HttpStatus expected = HttpStatus.CREATED;
            User expectedUser = new User();
            BDDMockito
                    .given(service.create(expectedUser))
                    .willReturn(expectedUser);

            // When
            ResponseEntity<User> response = controller.create(expectedUser);
            HttpStatus actual = response.getStatusCode();
            User actualUser = response.getBody();

            // Then
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(expectedUser, actualUser);
        }


    @Test
    public void testShow() {
        // Given
        HttpStatus expected = HttpStatus.OK;
        User expectedUser = new User();
        BDDMockito.
                given(service.findById(1))
                .willReturn(expectedUser);

        // When
        ResponseEntity<User> response = controller.findById(1);
        HttpStatus actual = response.getStatusCode();
        User actualUser = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testFindAll() {
        // Given
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User());
        expectedUsers.add(new User());
        expectedUsers.add(new User());

        HttpStatus expected = HttpStatus.OK;

        BDDMockito.
                given(service.findAllUsers())
                .willReturn(expectedUsers);

        // When
        ResponseEntity<Iterable<User>> response = controller.findAllUsers();
        HttpStatus actual = response.getStatusCode();
        List<User> actualUsers = (List<User>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedUsers, actualUsers);
    }

    @Test
    public void testFindPostsByUser() {
        // Given
        Set<Post> expectedPost = new HashSet<>();
        Post post1 = new Post();
        post1.setPostContent("Ada is cute; like if you agree!");
        post1.setPostTitle("Ada is cute.");
        post1.setPostSummary("Post about Ada");
        User user = new User();
        user.setId(1);
        user.setPosts(expectedPost);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito
                .given(service.create(user))
                .willReturn(user);
        BDDMockito.
                given(service.getPostsByUser(1))
                .willReturn(expectedPost);

        // When
        ResponseEntity<Iterable<Post>> response = controller.getPostsByUser(1);
        HttpStatus actual = response.getStatusCode();
        Set<Post> actualPost = (Set<Post>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPost, actualPost);
    }


    @Test
    public void testFindCommentsByUser() {
        // Given
        Set<Comments> expectedComments = new HashSet<>();
        Comments comments1 = new Comments();
        comments1.setComments("I appreciate your post");
        Comments comments2 = new Comments();
        comments2.setComments("You're so right");
        User user = new User();
        user.setId(1);
        user.setComments(expectedComments);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito
                .given(service.create(user))
                .willReturn(user);
        BDDMockito.
                given(service.getCommentsByUser(1))
                .willReturn(expectedComments);

        // When
        ResponseEntity<Iterable<Comments>> response = controller.getCommentsByUser(1);
        HttpStatus actual = response.getStatusCode();
        Set<Comments> actualComments = (Set<Comments>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedComments, actualComments);
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
}