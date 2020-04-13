package com.theocho.youflix.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theocho.youflix.repositories.VideoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Entity;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class VideoTest {
    @Autowired
    private VideoRepository videoRepository;

    Video testVideo;
    Video nullaryVideo;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        testVideo = new Video("sample Title", "sample description", "sample video url");
        nullaryVideo = new Video();
    }

    @After
    public void tearDown() throws Exception {
    }

    // TODO - write a test that will check whether the auto-generated id works as expected
    @Test
    public void auto_generated_id_works() {
//        when(testVideo.getId()).thenReturn(5l);
//        videoRepository.save(testVideo);
//        assertThat(testVideo.getId().isGreaterThan(0L));
//        Assert.assertNotNull(testVideo.getId());
//        assertTrue(videoRepository.testVideo.getId() > 0L);
    }

    @Test
    public void testClassSignatureAnnotations(){
        Assert.assertTrue(Video.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException{
        String expected = "{" +
                "\"id\":null," +
                "\"title\":\"sample Title\"," +
                "\"description\":\"sample description\"," +
                "\"url\":\"sample video url\"" +
            "}";
        ObjectMapper jsonWriter = new ObjectMapper();
        String json = jsonWriter.writeValueAsString(testVideo);
        Assert.assertEquals(expected, json);
    }

    @Test
    public void setId() {
        Long expected = 1l;
        nullaryVideo.setId(expected);
        Assert.assertEquals(expected, nullaryVideo.getId());
    }

    @Test
    public void getTitle() {
        String expected = "sample Title";
        Assert.assertEquals(expected, testVideo.getTitle());
    }

    @Test
    public void setTitle() {
        String expected = "new Title";
        nullaryVideo.setTitle(expected);
        Assert.assertEquals(expected, nullaryVideo.getTitle());
    }

    @Test
    public void getDescription() {
        String expected = "sample description";
        Assert.assertEquals(expected, testVideo.getDescription());
    }

    @Test
    public void setFileName() {
        String expected = "sample description";
        nullaryVideo.setDescription(expected);
        Assert.assertEquals(expected, nullaryVideo.getDescription());
    }

    @Test
    public void getVideoURL() {
        String expected = "sample video url";
        Assert.assertEquals(expected, testVideo.getUrl());
    }

    @Test
    public void setVideoURL() {
        String expected = "new video url";
        nullaryVideo.setUrl(expected);
        Assert.assertEquals(expected, nullaryVideo.getUrl());
    }

}
