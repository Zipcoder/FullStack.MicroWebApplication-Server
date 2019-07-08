package com.phoenixvideos.phoenixapp.repository;

import com.phoenixvideos.phoenixapp.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
}
