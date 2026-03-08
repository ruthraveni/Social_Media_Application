package com.kce.service;

import com.kce.bean.DataStore;
import com.kce.bean.Post;
import com.kce.bean.User;

public class PostService {
	 public void createPost(User user, String content) {

	        Post post = new Post(content, user);
	        DataStore.posts.add(post);

	        System.out.println("Post created successfully");
	    }

	    public void showFeed(User user) {

	        System.out.println("\n--- News Feed ---");

	        for (int i = DataStore.posts.size() - 1; i >= 0; i--) {

	            Post p = DataStore.posts.get(i);

	            if (user.getFriends().contains(p.getAuthor())) {

	                System.out.println("Author : " + p.getAuthor().getName());
	                System.out.println("Post   : " + p.getContent());
	                System.out.println("Likes  : " + p.getLikeCount());

	                System.out.println("Comments:");
	                for (String c : p.getComments()) {
	                    System.out.println("- " + c);
	                }
	            }
	        }
	    }

	    public void showAllPosts() {

	        if (DataStore.posts.isEmpty()) {
	            System.out.println("No posts available.");
	            return;
	        }

	        for (int i = 0; i < DataStore.posts.size(); i++) {

	            Post p = DataStore.posts.get(i);

	            System.out.println("\nPost Index : " + i);
	            System.out.println("Author     : " + p.getAuthor().getName());
	            System.out.println("Content    : " + p.getContent());
	            System.out.println("Likes      : " + p.getLikeCount());

	            System.out.println("Comments:");
	            for (String c : p.getComments()) {
	                System.out.println("- " + c);
	            }
	        }
	    }

	    public void likePost(int index) {

	        Post post = DataStore.posts.get(index);
	        post.likePost();

	        System.out.println("Post liked");
	    }

	    public void commentPost(int index, String comment) {

	        Post post = DataStore.posts.get(index);
	        post.addComment(comment);

	        System.out.println("Comment added");
	    }
	    
	    public void sharePost(int index, User receiver) {

	        if (index < 0 || index >= DataStore.posts.size()) {
	            System.out.println("Invalid post index");
	            return;
	        }

	        Post post = DataStore.posts.get(index);

	        System.out.println(receiver.getName() + " received a shared post");

	        System.out.println("Shared Post:");
	        System.out.println("Author  : " + post.getAuthor().getName());
	        System.out.println("Content : " + post.getContent());
	    }
}
