package com.example.WhatTheTekBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;

public class Comments {
    @ManyToOne
    private User commenter;
}
