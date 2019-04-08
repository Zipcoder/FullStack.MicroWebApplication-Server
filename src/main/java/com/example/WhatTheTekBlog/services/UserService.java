package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.User;
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

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        }
        return null;
    }

    public Iterable<Post> getPostsByUser(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get().getPosts();
        }
        return null;
    }

    public Iterable<Comments> getCommentsByUser(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get().getComments();
        }
        return null;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public User update(int userId, User updatedUser) {
        updatedUser.setId(userId);
        userRepository.deleteById(userId);
        return userRepository.save(updatedUser);
    }

}
