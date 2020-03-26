package com.theocho.youflix.dao;

import com.theocho.youflix.models.Video;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDaoImplementation implements VideoDao {

    public VideoDaoImplementation(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;


    @Override
    public List<Video> findAll() {
        return template.query("SELECT * FROM videos", new VideoRowMapper());
    }

    @Override
    public void insertVideo(Video video) {
        final String sql = "INSERT INTO videos(videoID, videoEtag, fileName, videoURL, thumbnailUrl) values(:videoID, :videoEtag, :fileName, :videoURL, :thumbnailUrl)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("videoID", video.getId())
                .addValue("videoEtag", video.getVideoEtag())
                .addValue("fileName", video.getFileName())
                .addValue("videoUrl", video.getVideoURL())
                .addValue("thumbnailUrl", video.getThumbnailURL());
        template.update(sql,param, holder);
    }

    @Override
    public void updateVideo(Video video) {
        final String sql = "UPDATE videos SET videoEtag=:videoEtag, fileName=:fileName, videoUrl=:videoUrl, thumbnailUrl=:thumbnailUrl WHERE videoID=:videoID";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employeeId", video.getId())
                .addValue("employeeName", video.getVideoEtag())
                .addValue("employeeEmail", video.getFileName())
                .addValue("employeeEmail", video.getVideoURL())
                .addValue("employeeAddress", video.getThumbnailURL());
        template.update(sql,param, holder);
    }

    @Override
    public void executeUpdateVideo(Video video) {
        final String sql = "UPDATE videos SET videoEtag=:videoEtag, fileName=:fileName, videoUrl=:videoUrl, thumbnailUrl=:thumbnailUrl WHERE videoID=:videoID";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("employeeId", video.getId());
        map.put("employeeName", video.getVideoEtag());
        map.put("employeeEmail", video.getFileName());
        map.put("employeeEmail", video.getVideoURL());
        map.put("employeeAddress", video.getThumbnailURL());
        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });

    }

    @Override
    public void deleteVideo(Video video) {
        final String sql = "DELETE FROM videos WHERE videoID=:videoID";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("videoID", video.getId());
        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }



}
