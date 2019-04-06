package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.TagNames;
import com.example.WhatTheTekBlog.entities.Posts;
import com.example.WhatTheTekBlog.entities.Tags;
import com.example.WhatTheTekBlog.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagsService {
    private TagsRepository tagsRepository;


    @Autowired
    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public Tags create(Tags tags){
//        List<Tags> listOfTags = (ArrayList<Tags>) this.tagsRepository.findAll();
//
//        try {
//            for (Tags tag: listOfTags) {
//                if(!tag.getTagName().equalsIgnoreCase(tags.getTagName())) {
//                    return this.tagsRepository.save(tags);
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("This tag already exists in the Database");
//        return tags;
        return this.tagsRepository.save(tags);
    }

//    public Iterable<Tags> findAll() {
//        return tagsRepository.findAll();
//    }
//
//
//    public List<Posts> listOfPostsBySpecifiedTag(Tags hashTag) {
//        List<Posts> postsList = new ArrayList<>();
//        for (Tags tags: tagsRepository.findAll()) {
//            if(tags.getListOfTags().)
//        }
//    }
//
//
    public Boolean delete(Integer id) {
        tagsRepository.deleteById(id);
        return true;
    }



}
