package com.theocho.youflix.dao;

import com.theocho.youflix.models.Video;

import java.util.List;

public interface VideoDao {
    List<Video> findAll();
    void insertVideo(Video video);
    void updateVideo(Video video);
    void executeUpdateVideo(Video video);
    public void deleteVideo(Video video);
}

