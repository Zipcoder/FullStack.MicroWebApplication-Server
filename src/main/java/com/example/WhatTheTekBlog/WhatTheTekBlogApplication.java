package com.example.WhatTheTekBlog;

import com.example.WhatTheTekBlog.Utils.RandomGenerator;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.services.CommentsService;
import com.example.WhatTheTekBlog.services.PostService;
import com.example.WhatTheTekBlog.services.TagsService;
import com.example.WhatTheTekBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.*;

@SpringBootApplication
public class WhatTheTekBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatTheTekBlogApplication.class, args);
	}

	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@Autowired
	CommentsService commentsService;

	@Autowired
	TagsService tagsService;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Random random = new Random();
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName(RandomGenerator.generateWord() + i);
			for (int j = 0; j < 5; j++) {
				Post post = new Post();
				post.setCreator(user);
				post.setPostTitle(RandomGenerator.generateWord());
				post.setPostContent(RandomGenerator.generateSentence(random.nextInt(100)));
				post.setPostSummary(RandomGenerator.generateSentence(1));
				Tags tags = new Tags();
				tags.setTagName(RandomGenerator.generateWord());
				Tags tags2 = new Tags();
				tags2.setTagName(RandomGenerator.generateWord());
				Tags tags3 = new Tags();
				tags3.setTagName(RandomGenerator.generateWord());
				Set<Post> postList = new HashSet<>();
				Set<Tags> tagSet = new HashSet<>();
				tagSet.add(tags);
				tagSet.add(tags2);
				tagSet.add(tags3);
				postList.add(post);
				tags.setListOfPosts(postList);
				post.setTagsSet(tagSet);

				Comments comments = new Comments();
				comments.setComments(String.format("Comment %d from user %d: \n%s", j, i, RandomGenerator.generateSentence(1)));
				comments.setUser(user);
				comments.setPost(post);
				user.addComment(comments);
				Comments comments1 = new Comments();
				comments1.setComments(String.format("Comment %d from user %d: \n%s", j, i, RandomGenerator.generateSentence(1)));
				comments1.setUser(user);
				comments1.setPost(post);
				//postService.createPost(post);
			}
			userService.create(user);
		}
	}


}
