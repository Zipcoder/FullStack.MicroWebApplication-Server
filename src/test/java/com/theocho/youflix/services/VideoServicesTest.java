package com.theocho.youflix.services;

import com.theocho.youflix.YouflixApplication;
import com.theocho.youflix.controllers.VideoController;
import com.theocho.youflix.models.Video;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
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

    @MockBean
    private VideoServices videoServices;

    private VideoController videoController;

//    @Mock
//    private VideoRepository videoRepository;

    Video testVideo;

    @Before
    public void setUp() throws Exception {
        testVideo = new Video("sample Etag", "sample file name", "sample video url", "sample thumbnail url");
        testVideo.setId(1L);
        this.videoController = new VideoController(videoServices);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create_a_video_Test() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Video expectedVideo = new Video(null, null, null, null);
        BDDMockito
                .given(videoServices.create(testVideo))
                .willReturn(testVideo);
        // When
        ResponseEntity<Video> response = videoController.createVideo(expectedVideo);
        HttpStatus actual = response.getStatusCode();
        Video actualVideo = response.getBody();
        // Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expectedVideo, actualVideo);
    }

    @Test
    public void show_one_video_Test() {
        // given
        Video expectedVideo = new Video("sample Etag", "sample file name", "sample video url", "sample thumbnail url");
        testVideo.setId(1L);
//        when(videoRepository.findById(1L)).thenReturn(java.util.Optional.of(expectedVideo));
        // when

        // then
        assertEquals(expectedVideo, videoServices.showOne(1L));
    }

    @Test
    public void show_all_videos_Test(){
        Assert.assertEquals(1,2);
    }

}
