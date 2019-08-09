package com.zipcodewilmington.videoproject.repositories;

import com.zipcodewilmington.videoproject.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
  @Query(value = "SELECT new com.zipcodewilmington.videoproject.models.VideoDTO(c.videoId, c.videoName, c.userId, c.videoPath, c.videoType) FROM Video c")
  Iterable<Video> findVideosByColumn();

  Video findVideoByVideoId(long id);
}
