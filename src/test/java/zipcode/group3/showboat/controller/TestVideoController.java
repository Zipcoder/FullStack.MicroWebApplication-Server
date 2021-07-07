package zipcode.group3.showboat.controller;


import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.VideoRepository;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc

public class TestVideoController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VideoRepository repositoryMock;

    @Test
    public void getTest() {
        Long givenId = 1L;
        Video expected = new Video("Short Video", null, null, null, null);
        String expectedJson = "{\"id\":null,\"title\":\"ShortVideo\",\"filepath\":null,\"datecreated\":null,\"description\":null}";
        Mockito.when(repositoryMock.findById(givenId)).thenReturn(Optional.of(expected));

//        mvc.perform(MockMvcRequestBuilders.get("/video/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedJson));

    }


}
