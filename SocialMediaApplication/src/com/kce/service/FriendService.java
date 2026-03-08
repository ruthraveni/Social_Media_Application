package com.kce.service;

import java.util.List;
import java.util.Scanner;

import com.kce.bean.DataStore;
import com.kce.bean.User;

public class FriendService {
	 public void sendFriendRequest(User from, User to) {

	        if (to.getFriendRequests().contains(from)) {
	            System.out.println("Request already sent");
	            return;
	        }

	        to.getFriendRequests().add(from);

	        System.out.println(from.getName() + " sent friend request to " + to.getName());
	    }

	    public void acceptRequest(User user, User requester) {

	        user.getFriendRequests().remove(requester);

	        user.getFriends().add(requester);
	        requester.getFriends().add(user);

	        System.out.println("Friend request accepted");
	    }

	    public void viewFriends(User user) {

	        System.out.println("Friends of " + user.getName());

	        for (User f : user.getFriends()) {

	            System.out.println(
	                    f.getName() + " | " +
	                    f.getAge() + " | " +
	                    f.getLocation() + " | " +
	                    f.getOccupation()
	            );
	        }
	    }

	    public void manageRequests(User user, Scanner sc) {

	        if (user.getFriendRequests().isEmpty()) {
	            System.out.println("No pending friend requests.");
	            return;
	        }

	        System.out.println("\nPending Friend Requests:");

	        for (int i = 0; i < user.getFriendRequests().size(); i++) {

	            User requester = user.getFriendRequests().get(i);

	            System.out.println(
	                    i + " | " +
	                    requester.getName() + " | " +
	                    requester.getAge() + " | " +
	                    requester.getLocation() + " | " +
	                    requester.getOccupation()
	            );
	        }

	        System.out.println("Enter request index:");
	        int index = sc.nextInt();

	        User requester = user.getFriendRequests().get(index);

	        System.out.println("1 Accept");
	        System.out.println("2 Reject");

	        int choice = sc.nextInt();

	        if (choice == 1) {

	            user.getFriends().add(requester);
	            requester.getFriends().add(user);

	            user.getFriendRequests().remove(requester);

	            System.out.println("Friend request accepted");

	        } else if (choice == 2) {

	            user.getFriendRequests().remove(requester);

	            System.out.println("Friend request rejected");
	        }
	    }

	   
	    public void showFriendSuggestions(User user) {

	        System.out.println("\n--- Friend Suggestions ---");

	        List<User> allUsers = DataStore.users;

	        for (User u : allUsers) {

	            if (u == user || user.getFriends().contains(u))
	                continue;

	            int mutualCount = 0;

	            for (User f : user.getFriends()) {

	                if (u.getFriends().contains(f)) {
	                    mutualCount++;
	                }
	            }

	            if (mutualCount > 0) {

	                System.out.println(
	                        u.getName() +
	                        " (Mutual Friends: " + mutualCount + ")"
	                );
	            }

	            else if (u.getLocation().equalsIgnoreCase(user.getLocation())
	                    || u.getAge() == user.getAge()) {

	                System.out.println(
	                        u.getName() +
	                        " (Matching Profile)"
	                        );
	            }

	            else {

	                System.out.println(
	                        u.getName() +
	                        " (Other User)"
	                );
	            }
	        }
	    }    
}
