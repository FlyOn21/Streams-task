package app.views;

import app.models.CreateUserModel;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class CreateUserView {
    private final CreateUserModel userModel = new CreateUserModel();

    public void createUser(Scanner scanner) {
        System.out.println("Create New User");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Phone Number (E164 format, example +380504121644): ");
        String phone = scanner.nextLine().trim();

        Hashtable<Boolean, List<String>> result = userModel.createUser(email, password, username, name, phone);

        if (result.containsKey(true)) {
            System.out.println("User created successfully.");
        } else {
            System.out.println("Failed to create user. Errors:");
            result.get(false).forEach(System.out::println);
        }
    }
}