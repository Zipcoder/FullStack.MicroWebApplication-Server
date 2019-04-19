package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tagName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Post> listOfPosts = new HashSet<>();

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

    public Set<Post> getListOfPosts() {
        return listOfPosts;
    }

    public void setListOfPosts(Set<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

    public void addPost(Post post) {
        this.listOfPosts.add(post);
    }

}
