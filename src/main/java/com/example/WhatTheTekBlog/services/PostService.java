package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.PostRepository;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    private PostRepository postRepository;
    private TagsRepository tagsRepository;

    @Autowired
    public PostService(PostRepository repository, TagsRepository tagsRepository) {
        this.postRepository = repository;
        this.tagsRepository = tagsRepository;
    }

    public Post createPost(Post post) {
        Set<Tags> tagsSet = new HashSet<>();
        post.getTagsSet().forEach(tags -> tagsSet.add(tagsRepository.findById(tags.getId()).get()));
        Post savedPost = this.postRepository.save(post);
        for (Tags tags : post.getTagsSet()) {
            Tags updatedTag = tagsRepository.findById(tags.getId()).get();
            updatedTag.addPost(savedPost);
            tagsRepository.deleteById(updatedTag.getId());
            tagsRepository.save(updatedTag);
        }
        return savedPost;
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
