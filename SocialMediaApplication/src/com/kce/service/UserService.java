package com.kce.service;

import com.kce.bean.DataStore;
import com.kce.bean.User;

public class UserService {
	 public User signup(String name, int age, String dob, String location, String occupation) {

	        User user = new User(name, age, dob, location, occupation);

	        DataStore.users.add(user);

	        System.out.println("User registered successfully");

	        return user;
	    }

	    public void viewUsers() {

	        for (int i = 0; i < DataStore.users.size(); i++) {

	            User u = DataStore.users.get(i);

	            System.out.println(
	                    i + " | " +
	                    u.getName() + " | " +
	                    u.getAge() + " | " +
	                    u.getDob() + " | " +
	                    u.getLocation() + " | " +
	                    u.getOccupation()
	            );
	        }
	    }
	}
