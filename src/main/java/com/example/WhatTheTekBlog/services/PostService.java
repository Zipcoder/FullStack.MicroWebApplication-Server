package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService(PostRepository repository) {
        this.postRepository = repository;
    }

    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return this.postRepository.findAll();
    }

    public Optional<Post> findByPostId(Long postId) {
        return this.postRepository.findById(postId);
    }

    public Post updatePost(Long postId, Post post) {
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
