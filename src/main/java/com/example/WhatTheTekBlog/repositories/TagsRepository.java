package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.models.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface TagsRepository extends CrudRepository<Tags,Integer> {
    Tags findByTagName(String name);
}
