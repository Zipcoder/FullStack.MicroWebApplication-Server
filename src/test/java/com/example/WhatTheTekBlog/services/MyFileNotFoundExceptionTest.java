package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.config.FileStorageProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class MyFileNotFoundExceptionTest {

//    @Autowired
//    private FileStorageProperties fileStorageProperties;
//
//    private final Path fileStorageLocation = null;
    Path filePath = null;

    @Test(expected = MyFileNotFoundException.class)
    public void testMyFileNotFoundException1() {
        try {
            Resource resource = new UrlResource(filePath.toUri());
            Files.createDirectories(filePath);
            if (!resource.exists()){
                throw new MyFileNotFoundException("Directory not found");
            }
        } catch (Exception e) {
            throw new MyFileNotFoundException("Directory not found");
        }

    }

    @Test(expected = MyFileNotFoundException.class)
    public void testMyFileNotFoundException2() {
        try {
            Resource resource = new UrlResource(filePath.toUri());
            Files.createDirectories(filePath);
            if (!resource.exists()){
                throw new MyFileNotFoundException("Directory not found");
            }
        } catch (Exception e) {
            throw new MyFileNotFoundException("Directory not found",e);
        }

    }

}
