package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface PostRepository extends JpaRepository <Post, Long> {

  Page<Post> findAll(Pageable pageable);
}
