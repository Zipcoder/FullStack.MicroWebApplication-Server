package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByName(String name);
}
