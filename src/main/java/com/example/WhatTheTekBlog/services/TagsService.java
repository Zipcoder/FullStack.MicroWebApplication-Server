package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.TagNames;
import com.example.WhatTheTekBlog.entities.Post;
import com.example.WhatTheTekBlog.entities.Tags;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class TagsService {
    private TagsRepository tagsRepository;


    @Autowired
    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }


    public Tags create(Tags tags){
        for (Tags tag: tagsRepository.findAll()) {
            if(tag.getTagName().equals(tags.getTagName())) {
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
            if(tag.getTagName().equals(hashName)) {
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

    public Boolean delete(Integer id) {
        tagsRepository.deleteById(id);
        return true;
    }

    public Boolean delete(String tagName) {
        List<Tags> listOfTags = (ArrayList<Tags>) this.tagsRepository.findAll();

        for (Tags tag: listOfTags) {
            if(tag.getTagName().equals(tagName)) {
                tagsRepository.delete(tag);
            }
        }

        return true;
    }



}
