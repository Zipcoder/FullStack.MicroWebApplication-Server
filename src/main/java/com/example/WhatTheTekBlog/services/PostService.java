package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.entities.Post;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

  @Autowired
  private PostRepository postsRepository;

  public PostService(PostRepository repository) {
    this.postsRepository = repository;
  }

  public PageRequest createPost(Integer page) {
    PageRequest request = new PageRequest(page, 1,Sort.Direction.DESC, "createdDate");
    return request;
  }

  public Page<Post> findAll(Pageable pageable) {
    return this.postsRepository.findAll(pageable);
  }

  public List<Post> findAllByDate(Pageable pageable){
    return postsRepository.findAll(new Sort(Sort.Direction.DESC,"createdDate"));
  }

  public Optional<Post> findById(Long postId) {
    return this.postsRepository.findById(postId);
  }

  public Boolean delete(Long postId) {
    this.postsRepository.deleteById(postId);
    return true;
  }


}
