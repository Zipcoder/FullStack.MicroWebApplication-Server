package com.example.WhatTheTekBlog;

import com.example.WhatTheTekBlog.config.FileStorageProperties;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
import com.example.WhatTheTekBlog.services.PostService;
import com.example.WhatTheTekBlog.services.TagsService;
import com.example.WhatTheTekBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.*;

@SpringBootApplication

@EnableConfigurationProperties ({
		FileStorageProperties.class
})

public class WhatTheTekBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatTheTekBlogApplication.class, args);


	}

}
