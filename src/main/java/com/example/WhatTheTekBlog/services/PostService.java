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
        post.getTagsSet().forEach(tags -> tagsSet.add(tagsRepository.findByTagName(tags.getTagName())));
        Post savedPost = this.postRepository.save(post);
        saveTags(post.getTagsSet(), savedPost);
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
        removeTags(originalPost.getTagsSet(), originalPost);
        originalPost.setTagsSet(new HashSet<>());
        saveTags(post.getTagsSet(), originalPost);
        postRepository.deleteById(originalPost.getPostID());
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


    private void saveTags(Set<Tags> tagsSet, Post savedPost) {
        for (Tags tags : tagsSet) {
            Tags updatedTag = tagsRepository.findByTagName(tags.getTagName());
            updatedTag.addPost(savedPost);
            tagsRepository.deleteById(updatedTag.getId());
            tagsRepository.save(updatedTag);
        }
    }

    private void removeTags(Set<Tags> tagsSet, Post originalPost) {
        for (Tags tags : tagsSet) {
            Tags updatedTag = tagsRepository.findByTagName(tags.getTagName());
            updatedTag.removePost(originalPost);
            tagsRepository.deleteById(updatedTag.getId());
            tagsRepository.save(updatedTag);
        }
    }
}
