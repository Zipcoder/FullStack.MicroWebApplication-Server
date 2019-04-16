
package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Post> posts = new LinkedHashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comments> comments = new LinkedHashSet<>();

    public User() { }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setCreator(this);
    }

    public void addComment(Comments comment) {
        comments.add(comment);
        comment.setUser(this);
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

}
