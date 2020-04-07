package com.videolibrary.zipcode.fullstackapp.controllers;

import com.videolibrary.zipcode.fullstackapp.services.VideoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc
class VideoControllerTest {

    @MockBean
    private VideoService videoService;

    @Autowired
 //   private MockMVC mockMVC;

   // @Test
  //  @DisplayName ()

    @Test
    public void addVideo() {
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

    @Test
    public void deleteVideo() {
    }
}
