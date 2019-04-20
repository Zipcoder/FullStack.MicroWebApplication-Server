package com.example.WhatTheTekBlog;

import com.example.WhatTheTekBlog.Utils.RandomGenerator;
import com.example.WhatTheTekBlog.models.User;
import com.example.WhatTheTekBlog.models.Comments;
import com.example.WhatTheTekBlog.models.Post;
import com.example.WhatTheTekBlog.models.Tags;
import com.example.WhatTheTekBlog.repositories.CommentsRepository;
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
	CommentsRepository commentsRepository;

	@Autowired
	TagsService tagsService;


	static List<String> tags = new ArrayList();
	static {
		tags.add("Java");
		tags.add("Castle");
		tags.add("Pineapple");
		tags.add("Mocha");
		tags.add("Oreo");
		tags.add("Python");
		tags.add("Ruby");
		tags.add("Rails");
	}

	public Tags generateTag() {
		Random random = new Random();
		List<Tags> tags = (List<Tags>) tagsService.findAllTags();
		return tags.get(random.nextInt(tags.size()));
	}

	//@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		for (String tag : tags) {
			Tags tags1 = new Tags();
			tags1.setTagName(tag);
			tagsService.createTags(tags1);
		}
		Random random = new Random();
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			String name = RandomGenerator.generateWord() + i;
			user.setName(name);
			List<Post> posts = new ArrayList<>();
			List<Comments> comments = new ArrayList<>();
			userService.create(user);
			for (int j = 0; j < 5; j++) {
				Post post = new Post();
				post.setCreator(user);
				post.setPostTitle(RandomGenerator.generateWord());
				post.setPostContent(RandomGenerator.generateSentence(random.nextInt(100)));
				post.setPostSummary(RandomGenerator.generateSentence(1));
//				tagsService.createTags(tags);
//				tagsService.createTags(tags2);

				Comments comment = new Comments();
				comment.setComments(RandomGenerator.generateSentence(1));
				comment.setUser(user);
				comment.setPost(post);
				Comments comments1 = new Comments();
				comments1.setComments(RandomGenerator.generateSentence(1));
				comments1.setUser(user);
				comments1.setPost(post);
				comments.add(comment);
				comments.add(comments1);
//				commentsRepository.save(comments);
//				commentsRepository.save(comments1);
				posts.add(post);
				postService.createPost(post);

				Tags tags = generateTag();
				posts.forEach(tags::addPost);
				tagsService.update(tags.getId(), tags);
				Tags tags2 = generateTag();
				posts.forEach(tags2::addPost);
				tagsService.update(tags2.getId(), tags2);
			}
			comments.forEach(comments1 -> commentsRepository.save(comments1));
		}
	}


}
