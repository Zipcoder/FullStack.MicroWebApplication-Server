package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class CommentsServiceTest {

    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJuaWNrbmFtZSI6InRlc3RpbmcxMjM1IiwibmFtZSI6ImRpdGljQG1haWxsaW5rLmxpdmUiLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvMGVmMWNkMjYxNjc1MzBmMDIwM2ExMTBiYzU3Yjg4YTc_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZkaS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAxOS0wNC0xN1QxNjoxMDo0OC41MjJaIiwiaXNzIjoiaHR0cHM6Ly93aGF0dGhldGVrLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1Y2I3NTAwODcyNDI5YjExNDgwMGY2YTIiLCJhdWQiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsImlhdCI6MTU1NTUyMjI3NiwiZXhwIjoxNTU1NTU4Mjc2LCJhdF9oYXNoIjoiYVFyTzB3WFJtS3JSVmZnSjE1VTZfQSIsIm5vbmNlIjoiLUlpRklnLWlydWRqNUtzRjltMGhrblZ2cFhQRGNSY1IifQ.Eq63Ta9VNUS9ITonZu-U9SaAkINeWawyGgg2rxlaPUPEtPHAjC2egaGzdZJAUXVmsySK2Is_0u9KvA-XQDuSv5rVxhxXQzn2jqePqzb_rIBUXALEtPTKiGGWsjX2_qiay_1x63K1nAWWSM0eVR0Fg67L01VCmRUAIoVZvPCmQHAccA71lvsDttvU0vFgBJ8NCJxBoG4ZQsRRdgHuBx_BmFH20B_hPp5WdWmQkl74UOL2aJaDn2VsHem4ZzGFJnjC3WlqxOamPkX9IVyKpcRvFb9VFEQxM5j2_nBrkyG5OLX20zEJlahEfU5RXeGUsq-nJFziJvQ52ZR2PI6MHWJ55w";

    @Mock
    private CommentsRepository mockCommentsRepo;

    @Mock
    private UserRepository mockUserRepo;

    @InjectMocks
    private CommentsService commentsService;


    @Before
    public void setup(){
        mockCommentsRepo = Mockito.mock(CommentsRepository.class);
        mockUserRepo = Mockito.mock(UserRepository.class);
        commentsService = new CommentsService(mockCommentsRepo, mockUserRepo);
    }

    @Test
    public void testCreateService(){
        //Given
        Comments comments = new Comments();
        comments.setCommentId(1L);
        Comments expected = new Comments();
        expected.setCommentId(1L);
        //When
        Mockito.when(mockCommentsRepo.save(comments)).thenReturn(expected);

        //Then
        Comments actual = commentsService.create(token, comments);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testCreateServiceUser(){
        //Given
        Comments comments = new Comments();
        comments.setCommentId(1L);
        Comments expected = new Comments();
        expected.setCommentId(1L);
        User testUser = new User();
        testUser.setId(1);
        Mockito.when(mockUserRepo.save(testUser)).thenReturn(testUser);
        comments.setUser(testUser);

        //When
        Mockito.when(mockCommentsRepo.save(comments)).thenReturn(expected);

        //Then
        Comments actual = commentsService.create(token, comments);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindById(){
        //Given
        Comments expected = new Comments();
        expected.setCommentId(1L);
        mockCommentsRepo.save(expected);
        //When
        Mockito.when(mockCommentsRepo.findById(1L)).thenReturn(java.util.Optional.of(expected));
        Comments actual = commentsService.findCommentById(1L).get();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindByIdError(){
        //Given
        Comments expected = new Comments();
        expected.setCommentId(1L);
        mockCommentsRepo.save(expected);
        //When
        Comments actual = commentsService.findCommentById(1234567L).get();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteService(){
        //Given
        Comments comments = new Comments();
        comments.setCommentId(1L);
        Comments comments1 = new Comments();
        comments1.setCommentId(2L);
        mockCommentsRepo.save(comments);
        mockCommentsRepo.save(comments1);

        List<Comments> expected = new ArrayList<>();
        expected.add(comments);
        expected.add(comments1);

        Mockito.when(mockCommentsRepo.findAll()).thenReturn(expected);

        //When
        commentsService.delete(1L);
        //Then
        List<Comments> actual = (List<Comments>) mockCommentsRepo.findAll();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAllService(){
        //Given
        Comments comments = new Comments();
        comments.setCommentId(1L);
        Comments comments1 = new Comments();
        comments1.setCommentId(2L);
        mockCommentsRepo.save(comments);
        mockCommentsRepo.save(comments1);

        List<Comments> expected = new ArrayList<>();
        expected.add(comments);
        expected.add(comments1);
        //When
        Mockito.when(mockCommentsRepo.findAll()).thenReturn(expected);
        List<Comments> actual = (List<Comments>) commentsService.findAllComments();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testgetPostsByComments(){
        //Given
        Post testPost = new Post();
        testPost.setPostID(100L);

        Comments comments = new Comments();
        comments.setCommentId(1L);
        comments.setPost(testPost);
        Comments comments1 = new Comments();
        comments1.setCommentId(2L);
        comments1.setPost(testPost);
        mockCommentsRepo.save(comments);
        mockCommentsRepo.save(comments1);

        List<Comments> expected = new ArrayList<>();
        expected.add(comments);
        expected.add(comments1);

        Mockito.when(mockCommentsRepo.findAll()).thenReturn(expected);

        //When
        commentsService.delete(1L);
        mockCommentsRepo.findAll().forEach(System.out::println);


        //When
        Mockito.when(mockCommentsRepo.findById(1L)).thenReturn(Optional.of(comments));
        List<Comments> actual = commentsService.findAllCommentByPost(100L);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateService(){
        //Given
        Comments comments = new Comments();
        comments.setCommentId(1L);
        comments.setComments("testing");
        Comments expected = new Comments();
        expected.setCommentId(2L);
        expected.setComments("expected");
        mockCommentsRepo.save(comments);

        //When
        Mockito.when(mockCommentsRepo.findById(1L)).thenReturn(Optional.of(comments));
        commentsService.updateComments(1L, expected);
        String actual = commentsService.findCommentById(1L).get().getComments();

        //Then
        Assert.assertEquals("expected", actual);
    }

}

