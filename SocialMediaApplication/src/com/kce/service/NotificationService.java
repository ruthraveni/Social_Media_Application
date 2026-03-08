package com.kce.service;

import com.kce.bean.User;

public class NotificationService {
	public void addNotification(User user, String message) {

        user.getNotifications().add(message);
    }

    public void showNotifications(User user) {

        if (user.getNotifications().isEmpty()) {

            System.out.println("No new notifications.");
            return;
        }

        System.out.println("\nNotifications for " + user.getName());

        for (String n : user.getNotifications()) {
            System.out.println("- " + n);
        }

        user.getNotifications().clear();
    }

}
