package com.videolibrary.zipcode.fullstackapp.Controllers;
import com.videolibrary.zipcode.fullstackapp.models.Video;
import com.videolibrary.zipcode.fullstackapp.services.VideoService;
import org.junit.Test;
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
public class VideoControllerTest {

    @MockBean
    private VideoService mockVideoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /video/1 - Found")
    public void testGetVideoById() throws Exception {
        //setup Mock service
        Video mockVideo = new Video ( 1, "TestVideo1", 5, 1 );

        doReturn ( Optional.of ( mockVideo ) ).when ( mockVideoService ).getVideoById ( 1 );
//        doReturn ( mockVideo ).when( mockVideoService).getVideoById ( 1 );
        //execute GET request
        mockMvc.perform ( get ( "/video/{id}", 1 ))
                .andExpect ( status ().isFound () )
                .andExpect ( content ().contentType ( MediaType.APPLICATION_JSON ) )
                .andExpect ( jsonPath ( "$.id,", is ( 1 ) ) )
                .andExpect ( jsonPath ( "$.title", is ( "TestVideo1" ) ) )
                .andExpect ( jsonPath ( "$.thumbsUp", is ( 5 ) ) )
                .andExpect ( jsonPath ( "$.thumbsDown", is ( 1 ) ) );
    }

    @Test
    @DisplayName ( "GET /video/1 - Not Found" )
   public void testVideoFoundById() throws Exception {
        doReturn ( Optional.empty () ).when ( mockVideoService ).getVideoById ( 1 );
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

    @Test
    public void deleteVideo() throws Exception {
        Video mockVideo = new Video ( 1, "TestVideo1", 5, 1 );
    }
}
