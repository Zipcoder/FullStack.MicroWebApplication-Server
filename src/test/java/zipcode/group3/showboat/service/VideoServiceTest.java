package zipcode.group3.showboat.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import zipcode.group3.showboat.repository.VideoRepository;

import static org.mockito.Mockito.*;

@SpringBootTest
public class VideoServiceTest {

    //testing that repository Delete method is called
    @Test
    public void deleteTest(){

        //Given
        VideoRepository repositoryMock = mock(VideoRepository.class);
        FileStorageService storageMock = mock(FileStorageService.class);
        VideoService service = new VideoService(repositoryMock, storageMock);
        Long givenId = 1L;

        //When
        Boolean actual = service.delete(givenId);

        //Then
        verify(repositoryMock, times(1)).deleteById(givenId);
        Assert.assertTrue(actual);



    }

}
