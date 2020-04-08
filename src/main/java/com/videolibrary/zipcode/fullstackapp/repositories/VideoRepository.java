package com.videolibrary.zipcode.fullstackapp.repositories;

import com.videolibrary.zipcode.fullstackapp.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    Video getVideoById(Long id);

    public ResponseEntity<Iterable<Video>> getVideoList();
}
