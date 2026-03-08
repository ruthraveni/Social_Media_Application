package com.kce.bean;

import java.util.ArrayList;
import java.util.List;

public class Post {
	  private String content;
	    private User author;
	    private int likeCount;

	    private List<String> comments = new ArrayList<>();

	    public Post(String content, User author) {
	        this.content = content;
	        this.author = author;
	        this.likeCount = 0;
	    }

	    public String getContent() {
	        return content;
	    }

	    public User getAuthor() {
	        return author;
	    }

	    public int getLikeCount() {
	        return likeCount;
	    }

	    public List<String> getComments() {
	        return comments;
	    }

	    public void likePost() {
	        likeCount++;
	    }

	    public void addComment(String comment) {
	        comments.add(comment);
	    }
}
