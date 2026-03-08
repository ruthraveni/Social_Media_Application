package com.kce.bean;

import java.util.ArrayList;
import java.util.List;

public class User {
	 private String name;
	    private int age;
	    private String dob;
	    private String location;
	    private String occupation;

	    private List<User> friends = new ArrayList<>();
	    private List<User> friendRequests = new ArrayList<>();
	    private List<String> notifications = new ArrayList<>();
	    
	    public User(String name, int age, String dob, String location, String occupation) {
	        this.name = name;
	        this.age = age;
	        this.dob = dob;
	        this.location = location;
	        this.occupation = occupation;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public String getOccupation() {
	        return occupation;
	    }

	    public List<User> getFriends() {
	        return friends;
	    }

	    public List<User> getFriendRequests() {
	        return friendRequests;
	    }
	    
	    public List<String> getNotifications() {
	        return notifications;
	    }
}
