package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
