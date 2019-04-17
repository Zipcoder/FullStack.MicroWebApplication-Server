package com.example.WhatTheTekBlog.Utils;

public enum TagNames {

    JAVA("Java"),
    CSS("CSS"),
    HTML("HTML"),
    JAVASCRIPT("JavaScript"),
    PYTHON("Python"),
    SPRING("Spring"),
    REACT("React");

    private String tagNames;

    TagNames(String tagNames) {
        this.tagNames = tagNames;
    }

    public String getTagNames() {
        return tagNames;
    }

    public void setTagNames(String tagNames) {
        this.tagNames = tagNames;
    }

}
