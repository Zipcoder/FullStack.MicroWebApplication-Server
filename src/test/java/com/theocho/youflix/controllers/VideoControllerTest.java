package com.theocho.youflix.controllers;

import com.theocho.youflix.repositories.VideoRepository;
import com.theocho.youflix.services.VideoServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VideoControllerTest {

    VideoController videoController;
    VideoServices videoServices;
    VideoRepository videoRepository;

    @Before
    public void setUp() throws Exception {
        videoServices = new VideoServices(videoRepository);
        videoController = new VideoController(videoServices);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createVideo() {
    }

    @Test
    public void hello() {
        String expected = "Hello World";
        assertEquals(expected,videoController.hello());
    }

    @Test
    public void show() {
    }

    @Test
    public void showAllVideos() {
    }
}
