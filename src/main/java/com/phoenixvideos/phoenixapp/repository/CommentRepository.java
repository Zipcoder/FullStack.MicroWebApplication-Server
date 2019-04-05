package com.phoenixvideos.phoenixapp.repository;

import com.phoenixvideos.phoenixapp.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
