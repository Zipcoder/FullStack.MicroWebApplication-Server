package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository repository) {
        this.postRepository = repository;
    }

    public Post createPost(Post post) {
       // System.out.println(post);
        return this.postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return this.postRepository.findAll();
    }

    public Optional<Post> findByPostId(Long postId) {
        return this.postRepository.findById(postId);
    }

    public Post updatePost(Long postId, Post post) {
        Post originalPost = this.postRepository.findByPostID(postId);
        originalPost.setPostTitle(post.getPostTitle());
        originalPost.setPostSummary(post.getPostSummary());
        originalPost.setPostContent(post.getPostContent());
        originalPost.setTagsSet(post.getTagsSet());
        return postRepository.save(originalPost);
    }

    public Boolean delete(Long postId) {
        postRepository.delete(postRepository.findByPostID(postId));
        return true;
    }

    public Set<String> getTags(Long postId) {
        Set<String> tags = new HashSet<>();
        postRepository.findByPostID(postId).getTagsSet().forEach(tag -> tags.add(tag.getTagName()));
       return tags;
    }
}
