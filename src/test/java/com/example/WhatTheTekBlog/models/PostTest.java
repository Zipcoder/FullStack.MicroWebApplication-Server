package com.example.WhatTheTekBlog.models;

import com.example.WhatTheTekBlog.services.UserService;
import org.hibernate.exception.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonTest
@RunWith(SpringRunner.class)
public class PostTest {

 //   private JacksonTester<Post> json;

    @MockBean
    UserService userService;

    private Post post;
    @Before
    public void setUp() {
        post = new Post();
    }

    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Post.class.isAnnotationPresent(Entity.class));
    }


//    @Value("classpath:post.json")
//    Resource resource;
//    PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
//    @Test
//    public void testCreateJson() throws IOException {
//
//
//
//        ObjectMapper jsonWriter = new ObjectMapper();
//        JacksonTester.initFields(this, jsonWriter);
//
//        Long givenId = 1L;
//        Comments comments = new Comments();
//        Tags tags = new Tags();
//        tags.setTagName("tag1");
//        comments.setComments("comment1");
//        Set<Comments> commentsList = new HashSet<>();
//        Set<Tags> tagsSet = new HashSet<>();
//        User author1 = new User();
//        author1.setId(1);
//        author1.setName("author1");
//
//        Post post = new Post();
//
//        post.setPostID(givenId);
//        post.setPostContent("Post1Content");
//        post.setPostTitle("Post1Title");
//        post.setPostSummary("Post1Summary");
//        post.setCreator(author1);
//        post.setCreatedDate(new Date());
//        comments.setUser(author1);
//        comments.setPost(post);
//        tags.setId(1);
//        post.setComments(commentsList);
//        post.setTagsSet(tagsSet);
//        post.setPostID(1L);
//
//        String json = jsonWriter.writeValueAsString(post);
//        System.out.println(jsonWriter.writeValueAsString(post));
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("post.json").getFile());
//        System.out.println(file.getAbsolutePath());
//
//
//        assertTrue(this.json.write(post).getJson().equals(file));
//
//
//    }

    @Test
    public void testGetPostID() {
        //Given
        Long expected = 1L;
        post.setPostID(expected);

        //When
        Long actual = post.getPostID();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPostIDNull() {
        //Given
        Long expected = null;
        post.setPostID(expected);

        //When
        Long actual = post.getPostID();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
        public void testGetTitle() {
        //Given
        String expected = "Post1Title";
        post.setPostTitle(expected);

        //When
        String actual = post.getPostTitle();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTitleNull() {
        //Given
        String expected = null;
        post.setPostTitle(expected);

        //When
        String actual = post.getPostTitle();

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testGetSummary() {
        //Given
        String expected = "Post1Summary";
        post.setPostSummary(expected);

        //When
        String actual = post.getPostSummary();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSummaryNull() {
        //Given
        String expected = null;
        post.setPostSummary(expected);

        //When
        String actual = post.getPostSummary();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetContent() {
        //Given
        String expected = "Post1Contented";
        post.setPostContent(expected);

        //When
        String actual = post.getPostContent();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetContentNull() {
        //Given
        String expected = null;
        post.setPostContent(expected);

        //When
        String actual = post.getPostContent();

        //Then
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void testGetComments() {
        //Given
        Set<Comments> expected = new HashSet<>();
        expected.add(new Comments());
        expected.add(new Comments());

        post.setComments(expected);

        //When
        Set<Comments> actual = post.getComments();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTags() {
        //Given
        Set<Tags> expected = new HashSet<>();
        expected.add(new Tags());
        expected.add(new Tags());

        post.setTagsSet(expected);

        //When
        Set<Tags> actual = post.getTagsSet();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUser() {
        //Given
        User expected = new User();
        expected.setName("Author1");
        expected.setId(1);

        post.setCreator(expected);

        //When
        User actual = post.getCreator();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCreatedDate() {
        //Given
        Date expected = new Date();

        post.setCreatedDate(expected);

        //When
        Date actual = post.getCreatedDate();

        //Then
        Assert.assertEquals(expected, actual);
    }

}


