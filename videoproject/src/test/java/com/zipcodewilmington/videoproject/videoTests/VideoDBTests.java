package com.zipcodewilmington.videoproject.videoTests;


import com.zipcodewilmington.videoproject.models.Video;
import com.zipcodewilmington.videoproject.repositories.VideoRepository;
import com.zipcodewilmington.videoproject.services.VideoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VideoDBTests {

  @Mock
  private VideoRepository repository;

  @InjectMocks
  private VideoService service;

  private List<Video> stubVideoEntities= Arrays.asList(
      new Video("Video1", "www.test.com", "/.mp4", 1000L),
      new Video("Video2", "www.test.com", "/.mp4", 2000L),
      new Video("Video3", "www.test.com", "/.mp4", 3000L));


  @Test
  public void findByColumnTest(){
    when(service.index()).thenReturn(stubVideoEntities);

    service.index();

    verify(repository, times(1)).findVideosByColumn();
  }

  @Test
  public void findByColumnTest2(){
    when(service.index()).thenReturn(stubVideoEntities);

    service.index();

    Iterable<Video> videos = service.index();

    Assert.assertEquals(videos, stubVideoEntities);
  }

  @Test
  public void findByColumnSizeTest(){
    when(service.index()).thenReturn(stubVideoEntities);

    Iterable<Video> videos = service.index();
    ArrayList<Video> videoList = new ArrayList<>();
    videos.forEach(videoList::add);

    Assert.assertEquals(videoList.size(), 3);
  }


  @Test
  public void findByIdTest(){
    when(service.getVideoById(1000L)).thenReturn(stubVideoEntities.get(0));

    service.getVideoById(1000L);

    verify(repository, times(1)).findVideoByVideoId(1000L);
  }

  @Test
  public void findByIdTest2(){
    when(service.getVideoById(1000L)).thenReturn(stubVideoEntities.get(0));

    Video video = service.getVideoById(1000L);

    Assert.assertEquals(video, stubVideoEntities.get(0));
  }

  @Test
  public void findByIdTest3(){
    when(service.getVideoById(1000L)).thenReturn(stubVideoEntities.get(0));

    Video video = service.getVideoById(1000L);

    Assert.assertEquals(video.getVideoName(), "Video1");
  }



}
