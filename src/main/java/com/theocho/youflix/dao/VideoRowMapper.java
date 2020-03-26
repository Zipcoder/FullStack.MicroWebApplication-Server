package com.theocho.youflix.dao;

import com.theocho.youflix.models.Video;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VideoRowMapper implements RowMapper<Video> {

    @Override
    public Video mapRow(ResultSet resultSet, int i) throws SQLException {
        Video video = new Video();
        video.setId(resultSet.getLong("videoID"));
        video.setVideoEtag(resultSet.getString("videoEtag"));
        video.setFileName(resultSet.getString("fileName"));
        video.setVideoURL(resultSet.getString("videoUrl"));
        video.setThumbnailURL(resultSet.getString("thumbnailUrl"));
        return video;
    }

}
