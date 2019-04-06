package com.example.WhatTheTekBlog.entities;

import com.example.WhatTheTekBlog.TagNames;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String tagName;
    private Set<Posts> listOfPosts = new HashSet<>();


    public Tags() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Posts> getListOfPosts() {
        return listOfPosts;
    }


    public void setListOfPosts(Set<Posts> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

}
