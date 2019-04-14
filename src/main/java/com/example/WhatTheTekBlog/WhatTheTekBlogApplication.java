package com.example.WhatTheTekBlog;

import com.example.WhatTheTekBlog.models.AppUser;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WhatTheTekBlogApplication {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(WhatTheTekBlogApplication.class, args);
	}

	@Autowired
	UserService userService;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		for (int i = 1; i <= 10; i++) {
			AppUser appUser = new AppUser();
			appUser.setId(i);
			appUser.setName("appUser" + i);
			for (int j = 0; j < 5; j++) {
				Post post = new Post();
				post.setCreator(appUser);
				post.setPostTitle(String.format("Title %d%d", i, j));
				post.setPostContent(String.format("Coooooonnnnnnnttttteeeeennnnnttttt"));
				post.setPostSummary("trialPost");
				Tags tags = new Tags();
				tags.setTagName("ThisIsAboutStuff" + i+j);
				Set<Post> postList = new HashSet<>();
				Set<Tags> tags1 = new HashSet<>();
				tags1.add(tags);
				postList.add(post);
				tags.setListOfPosts(postList);
				post.setTagsSet(tags1);


				Comments comments = new Comments();
				comments.setComments(String.format("Comment %d from appUser %d", j, i));
				comments.setAppUser(appUser);
				comments.setPost(post);
				appUser.addPost(post);
				appUser.addComment(comments);
			}
			userService.create(appUser);
		}
	}


}
