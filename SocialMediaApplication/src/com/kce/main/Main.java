package com.kce.main;

import java.util.Scanner;

import com.kce.bean.DataStore;
import com.kce.service.FriendService;
import com.kce.service.NotificationService;
import com.kce.service.PostService;
import com.kce.service.UserService;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        FriendService friendService = new FriendService();
        PostService postService = new PostService();
        NotificationService notificationService = new NotificationService();

        while (true) {

            System.out.println("\n====== SOCIAL MEDIA APP ======");
            System.out.println("1. User Signup");
            System.out.println("2. Friend Suggestions");
            System.out.println("3. Send Friend Request");
            System.out.println("4. Manage Friend Requests");
            System.out.println("5. View Friends");
            System.out.println("6. Create Post");
            System.out.println("7. News Feed");
            System.out.println("8. Like Post");
            System.out.println("9. Comment Post");
            System.out.println("10. Share Post");
            System.out.println("11. View Notifications");
            System.out.println("12. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter DOB (dd-mm-yyyy): ");
                    String dob = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter Occupation: ");
                    String occupation = sc.nextLine();

                    userService.signup(name, age, dob, location, occupation);
                    break;

                case 2:

                    userService.viewUsers();
                    System.out.print("Enter user index: ");
                    int uIndex = sc.nextInt();

                    friendService.showFriendSuggestions(DataStore.users.get(uIndex));
                    break;

                case 3:

                    userService.viewUsers();

                    System.out.print("Enter sender index: ");
                    int from = sc.nextInt();

                    System.out.print("Enter receiver index: ");
                    int to = sc.nextInt();

                    friendService.sendFriendRequest(
                            DataStore.users.get(from),
                            DataStore.users.get(to));

                    break;

                case 4:

                    userService.viewUsers();

                    System.out.print("Enter user index: ");
                    int userIndex = sc.nextInt();

                    friendService.manageRequests(DataStore.users.get(userIndex), sc);

                    break;

                case 5:

                    userService.viewUsers();

                    System.out.print("Enter user index: ");
                    int friendUser = sc.nextInt();

                    friendService.viewFriends(DataStore.users.get(friendUser));

                    break;

                case 6:

                    userService.viewUsers();

                    System.out.print("Enter user index: ");
                    int postUser = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Post Content: ");
                    String content = sc.nextLine();

                    postService.createPost(DataStore.users.get(postUser), content);

                    break;

                case 7:

                    userService.viewUsers();

                    System.out.print("Enter user index: ");
                    int feedUser = sc.nextInt();

                    postService.showFeed(DataStore.users.get(feedUser));

                    break;

                case 8:

                    postService.showAllPosts();

                    System.out.print("Select post index: ");
                    int likeIndex = sc.nextInt();

                    postService.likePost(likeIndex);

                    break;

                case 9:

                    postService.showAllPosts();

                    System.out.print("Select post index: ");
                    int commentIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter comment: ");
                    String comment = sc.nextLine();

                    postService.commentPost(commentIndex, comment);

                    break;

                case 10:

                    postService.showAllPosts();

                    System.out.print("Select post index: ");
                    int shareIndex = sc.nextInt();

                    userService.viewUsers();

                    System.out.print("Enter recipient index: ");
                    int recIndex = sc.nextInt();

                    postService.sharePost(
                            shareIndex,
                            DataStore.users.get(recIndex));

                    break;

                case 11:

                    userService.viewUsers();

                    System.out.print("Enter user index: ");
                    int notifyIndex = sc.nextInt();

                    notificationService.showNotifications(
                            DataStore.users.get(notifyIndex));

                    break;

                case 12:

                    System.out.println("Exiting Application...");
                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }

}
