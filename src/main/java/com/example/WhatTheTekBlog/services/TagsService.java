package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagsService {
    private TagsRepository tagsRepository;


    @Autowired
    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }


    public Tags createTags(Tags tags){
        for (Tags tag: tagsRepository.findAll()) {
            System.out.println(tag.getTagName());
            if(tag.getTagName() != null && tag.getTagName().equals(tags.getTagName())) {
                throw new IllegalArgumentException();
            }
        }
        return tagsRepository.save(tags);
    }

    public Iterable<Tags> findAllTags() {
        return tagsRepository.findAll();
    }

    public Optional<Tags> findTagById( Integer id) {
        return tagsRepository.findById(id);
    }

    public Set<Post> findPostsByTag(String hashName) {
        Set<Post> postsList = new HashSet<>();
        for (Tags tag: tagsRepository.findAll()) {
            if(tag.getTagName() != null && tag.getTagName().equals(hashName)) {
                postsList = tag.getListOfPosts();
            }
        }
        return postsList;
    }


    public Tags update(Integer id, Tags updatedTag) {
        Tags originalTag = tagsRepository.findById(id).get();
        originalTag.setListOfPosts(updatedTag.getListOfPosts());
        originalTag.setTagName(updatedTag.getTagName());
        tagsRepository.save(originalTag);
        return originalTag;
    }

    public Boolean deleteTags(Integer id) {
        tagsRepository.deleteById(id);
        return true;
    }

    public Boolean deleteTags(String tagName) {
        List<Tags> listOfTags = (ArrayList<Tags>) this.tagsRepository.findAll();

        for (Tags tag: listOfTags) {
            if(tag.getTagName() != null && tag.getTagName().equals(tagName)) {
                tagsRepository.delete(tag);
            }
        }

        return true;
    }



}
