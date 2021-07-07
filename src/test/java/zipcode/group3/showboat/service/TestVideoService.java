package zipcode.group3.showboat.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import zipcode.group3.showboat.ShowboatApplication;
import zipcode.group3.showboat.controller.VideoController;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.VideoRepository;

import java.io.File;
import java.util.Optional;

import static org.mockito.Mockito.*;

//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ShowboatApplication.class)
@SpringBootTest
public class TestVideoService {

//
//    private VideoController otherController;
//
//    @MockBean
//    private VideoService serviceMock;
//
//    @Before
//    public void setup() {
//        this.otherController = new VideoController(serviceMock);
//    }

    @Test
    public void readTest() {
        VideoService service = mock(VideoService.class);
        VideoController controller = new VideoController(service);
        Video expected = new Video(
                "New Video",
                null,
                null,
                null,
                null
        );
        Long givenId = 1L;
        when(service.read(givenId)).thenReturn(expected);
//        BDDMockito.given(service.read(givenId))
//                .willReturn(expected);

        //When
//        ArgumentCaptor<Optional> captor = ArgumentCaptor.forClass(Optional.class);



        ResponseEntity<Video> response = controller.get(givenId);
        HttpStatus actual = response.getStatusCode();
        Video actualVideo = response.getBody();

        verify(service, times(1)).read(givenId);

        Assert.assertEquals(HttpStatus.OK, actual);
        Assert.assertEquals(expected, actualVideo);

    }

    @Test
    public void updateTest() {

        // Given
        VideoRepository repositoryMock = mock(VideoRepository.class);
        FileStorageService storageMock = mock(FileStorageService.class);
        VideoService service = new VideoService(repositoryMock, storageMock);

        Video start = new Video("Cool Video", null, null, null, null);
        Video expected = new Video("Rad Video", null, null, null, null);

        // When
        when(repositoryMock.findById(1L)).thenReturn(Optional.of(start));
        when(repositoryMock.save(start)).thenReturn(expected);

        Video actual = service.update(1L, expected);

        // Then
        verify(repositoryMock, times(1)).findById(1L);
        verify(repositoryMock, times(1)).save(start);

        System.out.println(actual.getTitle());

        Assert.assertEquals(expected.getTitle(), actual.getTitle());

    }

    @Test
    public void deleteTest() {

        // Given
        VideoRepository repositoryMock = mock(VideoRepository.class);
        FileStorageService storageMock = mock(FileStorageService.class);
        VideoService service = new VideoService(repositoryMock, storageMock);

        Long givenId = 1L;

        // When
        Boolean actual = service.delete(givenId);

        // Then
        verify(repositoryMock, times(1)).deleteById(givenId);

        Assert.assertTrue(actual);

    }



}
