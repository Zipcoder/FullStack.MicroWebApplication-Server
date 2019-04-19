package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.models.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagsRepository extends CrudRepository<Tags,Integer> {
    Optional<Tags> findByTagName(String name);
}
