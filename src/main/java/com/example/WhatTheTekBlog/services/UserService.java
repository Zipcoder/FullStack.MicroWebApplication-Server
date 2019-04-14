package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.AppUser;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public AppUser findById(int userId) {
        return userRepository.findById(userId).get();
    }

    public AppUser findByName(String name) {
        return userRepository.findByName(name);
    }

    public Iterable<Post> getPostsByUser(int userId) {
        return userRepository.findById(userId).get().getPosts();
    }

    public Iterable<Comments> getCommentsByUser(int userId) {
        return userRepository.findById(userId).get().getComments();
    }

    public AppUser create(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public boolean delete(int userId) {
        userRepository.deleteById(userId);
        return true;
    }

    public AppUser update(int userId, AppUser updatedAppUser) {
        AppUser appUser = userRepository.findById(userId).get();
        appUser.setName(updatedAppUser.getName());
        appUser.setEmail(updatedAppUser.getEmail());
        appUser.setEmail(updatedAppUser.getEmail());
        appUser.setComments(updatedAppUser.getComments());
        appUser.setPosts(updatedAppUser.getPosts());
        return appUser;
    }

}
