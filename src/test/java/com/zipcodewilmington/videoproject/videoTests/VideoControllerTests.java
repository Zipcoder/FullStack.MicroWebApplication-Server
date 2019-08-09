package com.zipcodewilmington.videoproject.videoTests;

import com.zipcodewilmington.videoproject.controllers.VideoController;
import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
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

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class VideoControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private VideoRepository repository;


  @Test
  public void testShow() throws Exception {
    Long videoId = 1000L;
    BDDMockito
      .given(repository.findVideoByVideoId(videoId))
      .willReturn(new Video("Video1", "www.test.com", "mp4", 1L));

    String expectedContent = "{\"videoId\":null,\"videoName\":\"Video1\",\"videoPath\":\"www.test.com\",\"userId\":null,\"videoType\":\"mp4\",\"videoSize\":1,\"videoBytes\":null}";
    this.mvc.perform(MockMvcRequestBuilders
      .get("/videos/videostorage/" + videoId))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string(expectedContent));
  }

}
