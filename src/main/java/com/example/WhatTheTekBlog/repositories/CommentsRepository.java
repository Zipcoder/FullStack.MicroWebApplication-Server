package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.models.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {


}
