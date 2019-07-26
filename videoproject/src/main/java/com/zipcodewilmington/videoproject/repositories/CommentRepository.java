package com.zipcodewilmington.videoproject.repositories;


import com.zipcodewilmington.videoproject.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.videoId = ?1")
    Collection<Comment> findCommentByVideoId(int videoId);

    Iterable<Comment> findCommentsByVideoId(int videoId);
}
