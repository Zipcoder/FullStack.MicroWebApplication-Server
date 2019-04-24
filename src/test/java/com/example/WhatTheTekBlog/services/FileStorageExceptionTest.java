package com.example.WhatTheTekBlog.services;

import com.example.WhatTheTekBlog.WhatTheTekBlogApplication;
import com.example.WhatTheTekBlog.config.FileStorageProperties;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WhatTheTekBlogApplication.class)
public class FileStorageExceptionTest {

    @Autowired
    private FileStorageProperties fileStorageProperties;

    private final Path fileStorageLocation = null;

    @Test(expected = RuntimeException.class)
    public void testFileStorageException1() {
        try {
            Files.createDirectories(fileStorageLocation);
        }
        catch (Exception e){
            throw new FileStorageException("Directory not found");
        }

    }

    @Test(expected = RuntimeException.class)
    public void testFileStorageException2() {
        try {
            Files.createDirectories(fileStorageLocation);
        }
        catch (Exception e){
            throw new FileStorageException("Directory not found", e);
        }

    }

}
