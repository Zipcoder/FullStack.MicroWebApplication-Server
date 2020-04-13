package com.theocho.youflix.services;

import com.theocho.youflix.YouflixApplication;
import com.theocho.youflix.controllers.VideoController;
import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.doReturn;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = YouflixApplication.class)
public class VideoServicesTest {

    @InjectMocks
    private VideoServices videoServices;

    private VideoController videoController;

    @Mock
    private VideoRepository videoRepository;

    Video testVideo;

    @Before
    public void setUp() throws Exception {
        testVideo = new Video("sample title", "sample url", "sample description");
        testVideo.setId(1L);
//        videoServices = new VideoServices(videoRepository);
        this.videoController = new VideoController(videoServices);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create_a_video_Test() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        BDDMockito
                .given(videoServices.create(testVideo))
                .willReturn(testVideo);
        // When
        ResponseEntity<Video> response = videoController.createVideo(testVideo);
        HttpStatus actual = response.getStatusCode();
        Video actualVideo = response.getBody();
        // Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(testVideo, actualVideo);
    }

    @Test
    public void show_one_video_Test() {
        // given
        Long testVideoId = 1L;
        HttpStatus expectedHttpStatus = HttpStatus.OK;
        Video expectedVideo = new Video(null, null, null);
        BDDMockito
                .given(videoServices.showOne(testVideoId))
                .willReturn(expectedVideo);
        // when
        ResponseEntity<Video> response = videoController.show(testVideoId);
        HttpStatus actualHttpStatus = response.getStatusCode();
        Video actualVideo = response.getBody();
        // then
        Assert.assertEquals(expectedHttpStatus,actualHttpStatus);
//        Assert.assertEquals(expectedVideo, actualVideo);
    }

    @Test
    public void show_all_videos_Test(){
        Assert.assertEquals(1,2);
    }

}
