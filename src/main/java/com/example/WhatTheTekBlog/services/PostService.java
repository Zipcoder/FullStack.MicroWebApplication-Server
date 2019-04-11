package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

//  @Autowired
//  private TagsService tagsService;
//
//  @Autowired
//  private UserService userService;

  public PostService(PostRepository repository) {
    this.postRepository = repository;
  }

  public Post createPost(Post post)  {
   // PageRequest request = new PageRequest(page, 1,Sort.Direction.DESC, "createdDate");
    return this.postRepository.save(post);
  }

  public Iterable<Post> findAll(){
    return this.postRepository.findAll();
  }

  public Page<Post> findAllByPages(Pageable page) {
   return postRepository.findAll(page);
  }

  public Iterable<Post> findAllByDate(Pageable pageable){
    return postRepository.findAll(new Sort(Sort.Direction.DESC,"createdDate"));
  }

  public Optional<Post> findByPostId(Long postId) {
    return this.postRepository.findById(postId);
  }

  public Post updatePost(Long postId, Post post){
    Post originalPost = this.postRepository.getOne(postId);
    originalPost.setPostTitle(post.getPostTitle());
    originalPost.setPostSummary(post.getPostSummary());
    originalPost.setPostContent(post.getPostContent());

    return this.postRepository.save(originalPost);

  }

  public Boolean delete(Long postId) {
    this.postRepository.deleteById(postId);
    return true;
  }


}
