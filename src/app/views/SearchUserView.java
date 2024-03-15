package app.views;

import app.entitys.User;
import app.models.UserExplorerModel;
import app.utils.Printer;

import java.util.List;
import java.util.Scanner;

public class SearchUserView {
    private final UserExplorerModel allUsersModel = new UserExplorerModel();

    private String searchType;

    private static final String searchMenu = """
            ------------ SEARCH USERS--------------
            Choice 1 => search by username
            Choice 2 => search by email
            Choice 3 => search by phone
            Choice 4 => back to main menu
            """;



    public void searchUsers(Scanner scanner) {
        while (true) {
            System.out.println(searchMenu);

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("Input search username query: ");
                    String searchUsername  = scanner.nextLine().trim();
                    searchType = "username";
                    searchProcessing(searchUsername);
                    return;
                case "2":
                    System.out.println("Input search email query: ");
                    String searchEmail  = scanner.nextLine().trim();
                    searchType = "email";
                    searchProcessing(searchEmail);
                    return;
                case "3":
                    System.out.println("Input search phone query: ");
                    String searchPhone  = scanner.nextLine().trim();
                    searchType = "phone";
                    searchProcessing(searchPhone);
                    return;
                case "4":
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private void searchProcessing(String searchData) {
        List<User> users = allUsersModel.searchUsers(searchData, searchType);
        if (users.isEmpty()) {
            System.out.println("We didn't find anything, sorry");
            return;
        }
        Printer.printUser(users, false);
    }
}
