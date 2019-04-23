package com.example.WhatTheTekBlog.controllers;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import com.example.WhatTheTekBlog.services.TagsService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TagsControllerTest {

    private Tags tag;

    @Autowired
    private MockMvc mvc;

    @MockBean
    TagsService tagsService;

    @MockBean
    TagsRepository tagsRepository;

    @Before
    public void setUp() {
        this.tag = new Tags();
        String tagName = "Avengers";
        Integer id = 1;
        tag.setId(id);
        tag.setTagName(tagName);
//        Set<Post> postByTags = new HashSet<>();
//        Post post1 = new Post();
//        post1.setPostID(1l);
//        post1.setPostTitle("Civil War");
//        Post post2 = new Post();
//        post2.setPostID(2l);
//        post2.setPostTitle("Infinity War");
//        postByTags.add(post1);
//        postByTags.add(post2);
//        tag.setListOfPosts(postByTags);
    }

    @Test
    public void createTest() throws Exception {
        //Given
        BDDMockito.given(tagsService.createTags(tag)).willReturn(tag);
        //When
        String expectedContent =  "{\"id\":1,\"tagName\":\"Avengers\"}";
        //Then
        this.mvc.perform(MockMvcRequestBuilders
                .post("/createTag")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testFindAll() throws Exception {
        //Given
        Tags tag2 = new Tags();
        tag2.setId(2);
        tag2.setTagName("End Game");
        tagsService.createTags(tag);
        tagsService.createTags(tag2);
        List<Tags> tagList = new ArrayList<>();
        tagList.add(tag);
        tagList.add(tag2);
        Iterable<Tags> tagsIterable = tagList;
        //When
        BDDMockito.given(tagsService.findAllTags()).willReturn(tagsIterable);
        //Then
        String expectedContent = "[{\"id\":1,\"tagName\":\"Avengers\",\"listOfPosts\":[]},{\"id\":2,\"tagName\":\"End Game\",\"listOfPosts\":[]}]";
        this.mvc.perform(MockMvcRequestBuilders.get("/tags")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void findTagByIdTest() throws Exception {
        //Given
        BDDMockito.given(tagsService.findTagById(1)).willReturn((Optional.of(tag)));
        //Then
        String expectedContent = "{\"id\":1,\"tagName\":\"Avengers\",\"listOfPosts\":[]}";
        this.mvc.perform(MockMvcRequestBuilders.get("/tags/1")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void findPostByTagTest() throws Exception {
        //Given

        Post post = new Post();
        Long givenId = 1L;
        User author1 = new User();
        post.setPostID(givenId);
        post.setPostContent("Post1Content");
        post.setPostTitle("Post1Title");
        post.setPostSummary("Post1Summary");
        post.setCreator(author1);
        Set<Post> postSet = new HashSet<>();
        postSet.add(post);
        tag.setListOfPosts(postSet);

        //When
        BDDMockito.given(tagsService.findPostsByTag(tag.getTagName())).willReturn(tag.getListOfPosts());
        //Then
        String expectedContent = "[{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-23\",\"creator\":{\"id\":null,\"name\":null},\"myFile\":null}]";

        this.mvc.perform(MockMvcRequestBuilders.get("/tags/posts/Avengers")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void updateTest() throws Exception {
        //Given
        Integer originalTagId = 1;
        Tags tag2 = new Tags();
        tag2.setId(2);
        tag2.setTagName("End Game");

        //When
        BDDMockito.given(tagsRepository.findById(originalTagId)).willReturn(Optional.of(tag));
        //Then
        String expectedContent = "{\"id\":1,\"tagName\":\"End Game\",\"listOfPosts\":[]}";
        this.mvc.perform(MockMvcRequestBuilders.put("/updateTag/1").content(expectedContent).
                accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findFilteredPostsByTagTest() throws Exception {
        //Given
        Post post = new Post();
        Long givenId = 1L;
        User author1 = new User();
        post.setPostID(givenId);
        post.setPostContent("Post1Content");
        post.setPostTitle("Post1Title");
        post.setPostSummary("Post1Summary");
        post.setCreator(author1);
        Set<Post> postSet = new HashSet<>();
        postSet.add(post);
        tag.setListOfPosts(postSet);
        Tags tag2 = new Tags();
        tag2.setId(2);
        tag2.setTagName("EndGame");
        tag2.setListOfPosts(postSet);
        List<String> tagsList = new ArrayList<>();
        tagsList.add("Avengers");
        tagsList.add("EndGame");

        //When
        BDDMockito.given(tagsService.findFilteredPostsByTag(tagsList)).willReturn(postSet);
        String expectedContent = "[{\"postID\":1,\"postTitle\":\"Post1Title\",\"postSummary\":\"Post1Summary\",\"postContent\":\"Post1Content\",\"createdDate\":\"2019-04-23\",\"creator\":{\"id\":null,\"name\":null},\"myFile\":null}]";
        //Then
        this.mvc.perform(MockMvcRequestBuilders.get("/tags/filteredPosts/Avengers,EndGame")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void deleteTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/deleteTags/Avengers")).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}
