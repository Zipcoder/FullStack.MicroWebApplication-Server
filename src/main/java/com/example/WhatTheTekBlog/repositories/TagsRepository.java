package com.example.WhatTheTekBlog.repositories;

import com.example.WhatTheTekBlog.entities.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends CrudRepository<Tags,Integer> {
}
