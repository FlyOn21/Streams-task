package app.views;

import app.entitys.User;
import app.models.UserExplorerModel;
import app.utils.Printer;

import java.util.AbstractMap;
import java.util.List;
import java.util.Scanner;

public class SpecificUserView {

    private final UserExplorerModel AllUsersOrSpecificUserModel = new UserExplorerModel();
    public void showUser (Scanner scanner) {
        System.out.println("Please enter your credential: ");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        AbstractMap.SimpleEntry<List<User>, List<String>> result = AllUsersOrSpecificUserModel.specificUserGet(
                email, password
        );
        if (!result.getValue().isEmpty()) {
            System.out.print("Error exist: ");
            result.getValue().forEach(System.out::println);
        } else {
            Printer.printUser(result.getKey(), true);
        }
    }
}
