package app.controllers;

import app.views.*;

import java.util.Scanner;

public class UserController {
    public void usersControllerProcessing() {
        String title = """
                ############################
                Realize home work 12 Stream
                ############################
                """;
        System.out.println(title);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String menu = """ 
                    --------------
                    Choice action:
                    --------------
                    Choice 1 => see all users list
                    Choice 2 => search users
                    Choice 3 => see specific user
                    Choice 4 => create new user
                    Choice 5 => update exist user
                    Choice 6 => delete user
                    Choice 7 => stop and exit
                    """;
            System.out.println(menu);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    AllUsersView allUsersView = new AllUsersView();
                    allUsersView.showAllUsers();
                    break;
                case "2":
                    SearchUserView searchDataView = new SearchUserView();
                    searchDataView.searchUsers(scanner);
                    break;
                case "3":
                    SpecificUserView specificUserView = new SpecificUserView();
                    specificUserView.showUser(scanner);
                    break;
                case "4":
                    CreateUserView createUserView = new CreateUserView();
                    createUserView.createUser(scanner);
                    break;
                case "5":
                    UpdateUserView updateUserView = new UpdateUserView();
                    updateUserView.updateShow(scanner);
                    break;
                case "6":
                    DeleteUserView deleteUserView = new DeleteUserView();
                    deleteUserView.showDelete(scanner);
                    break;
                case "7":
                    running = false;
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
