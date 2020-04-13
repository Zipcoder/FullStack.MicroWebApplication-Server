package com.videolibrary.zipcode.fullstackapp.controllers;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.services.VideoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestVideoController {

    @MockBean
    private VideoService mockVideoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName ( "GET /video1 - Found" )
    public void testGetVideoById() throws Exception {
        //setup Mock Service
        Video mockVideo = new Video ( 1L, "video1", "https:/videolibrary-video-bucket.s3.amazonaws.com/bobs");
        doReturn(mockVideo).when(mockVideoService).create(mockVideo);
        doReturn(Optional.of(mockVideo)).when(mockVideoService).show(1L);
        //execute GET request
        mockMvc.perform ( get ( "/video/{id}", 1 ) )
                .andExpect ( status ().isFound () )
                .andExpect ( content ().contentType ( MediaType.APPLICATION_JSON ) )
                .andExpect ( jsonPath ( "$.id", is ( 1 ) ) )
                .andExpect ( jsonPath ( "$.thumbsUp", is ( 5 ) ) )
                .andExpect ( jsonPath ( "$.thumbsDown", is(1 ) ))
                .andExpect ( jsonPath ( "$.videoTitle", is ( "TestVideo1" ) ) )
                .andExpect ( jsonPath ("$.videoPath", is("urlPath")  ));
        }

    @Test
    @DisplayName ( "GET /video/1 - Not Found" )
   public void testVideoFoundById() throws Exception {
        doReturn ( Optional.empty () ).when ( mockVideoService ).show ( 2L );
        mockMvc.perform ( get ("/video/{id}, 1") )
                .andExpect ( status ().isNotFound ());
    }

    @Test
    public void getVideo() {
    }

    @Test
    public void getVideoList() {
    }

    @Test
    public void updateVideo() {
    }

//    @Test
//    public void deleteVideo() throws Exception {
//        Video mockVideo = new Video ( 1, "TestVideo1", 5, 1 );
//    }
}
