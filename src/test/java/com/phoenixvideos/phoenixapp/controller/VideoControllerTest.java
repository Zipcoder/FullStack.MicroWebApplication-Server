package com.phoenixvideos.phoenixapp.controller;

import com.phoenixvideos.phoenixapp.model.Video;
import com.phoenixvideos.phoenixapp.repository.VideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class VideoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VideoRepository repository;

    @Test
    public void getAllVideosTest() throws Exception {

        String testPath = "https://s3.us-east-2.amazonaws.com/phoenix.videos/BigBuckBunny.mp4";
        String testPath2 = "https://s3.us-east-2.amazonaws.com/phoenix.videos/IMG_4786.mp4";
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video("BigBuckBunny", testPath, 2L));
        videos.add(new Video("Zipcode window", testPath2,3L));

        BDDMockito
                .given(repository.findAll())
                .willReturn(videos);

        String expectedContent = "[{\"id\":2," +
               "\"title\":\"BigBuckBunny\"," +
                "\"description\":null," +
                "\"format\":\"video/mp4\"," +
                "\"path\":\"https://s3.us-east-2.amazonaws.com/phoenix.videos/BigBuckBunny.mp4\"," +
                "\"uniqueName\":null," +
                "\"user\":null" +
                "}," +
                "{" +
                "\"id\":3," +
                "\"title\":\"Zipcode window\"," +
                "\"description\":null," +
                "\"format\":\"video/mp4\"," +
                "\"path\":\"https://s3.us-east-2.amazonaws.com/phoenix.videos/IMG_4786.mp4\"," +
                "\"uniqueName\":null," +
                "\"user\":null" +
                "}" +
                "]";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/videos/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void getAllVideosWhenNoVideosPresentTest() throws Exception {

        ArrayList<Video> videos = new ArrayList<>();

        BDDMockito
                .given(repository.findAll())
                .willReturn(videos);

        String expectedContent = "[]";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/videos/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
    @Test
    public void getVideoTest() throws Exception {

        String testPath = "https://s3.us-east-2.amazonaws.com/phoenix.videos/BigBuckBunny.mp4";
        Video video = new Video("BigBuckBunny", testPath, 2L);

        BDDMockito
                .given(repository.findById(2L))
                .willReturn( Optional.of(video));

        String expectedContent = "{\"id\":2," +
                "\"title\":\"BigBuckBunny\"," +
                "\"description\":null," +
                "\"format\":\"video/mp4\"," +
                "\"path\":\"https://s3.us-east-2.amazonaws.com/phoenix.videos/BigBuckBunny.mp4\"," +
                "\"uniqueName\":null," +
                "\"user\":null" +
                "}";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/videos/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
    @Test
    public void getVideoNegetiveTest() throws Exception {

        BDDMockito
                .given(repository.findById(2L))
                .willReturn( Optional.empty());

        String expectedContent = "";

        this.mvc.perform(MockMvcRequestBuilders
                .get("/videos/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

}
