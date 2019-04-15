package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.models.User;
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

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User findByEmail(String name) {
        return userRepository.findByEmail(name).get();
    }

    public Iterable<Post> getPostsByUser(int userId) {
        return userRepository.findById(userId).get().getPosts();
    }

    public Iterable<Comments> getCommentsByUser(int userId) {
        return userRepository.findById(userId).get().getComments();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int userId) {
        userRepository.deleteById(userId);
        return true;
    }

    public User update(int userId, User updatedUser) {
        User user = userRepository.findById(userId).get();
        user.setName(updatedUser.getName());
        user.setComments(updatedUser.getComments());
        user.setPosts(updatedUser.getPosts());
        return user;
    }

    public boolean contains(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
