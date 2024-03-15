package app.views;

import app.models.UpdateUserModel;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class UpdateUserView {
    private final UpdateUserModel updateUserModel = new UpdateUserModel();

    private String email;

    private static final String updateMenu = """
            ------------ UPDATE USER --------------
            Choice 1 => update username
            Choice 2 => update password
            Choice 3 => update isActive
            Choice 4 => update isAdmin
            Choice 5 => update phone
            Choice 6 => update name
            Choice 7 => back to main menu
            """;

    private void updateProduct(Scanner scanner) {
        while (true) {
            System.out.println(updateMenu);

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            int checkInt;
            boolean isUpdated;
            switch (choice) {
                case "1":
                    System.out.println("Input new username: ");
                    String inputUsername  = scanner.nextLine().trim();
                    isUpdated = updateUserModel.updateUsername(email, inputUsername);
                    printUpdateStatus(isUpdated);
                    return;
                case "2":
                    System.out.println("Input new password: ");
                    String inputPassword  = scanner.nextLine().trim();
                    isUpdated = updateUserModel.updatePassword(email, inputPassword);
                    printUpdateStatus(isUpdated);
                    return;
                case "3":
                    System.out.println("Input new isActive status (0 - false, 1 - true): ");
                    String inputIsActive  = scanner.nextLine().trim();
                    try {
                        checkInt = Integer.parseInt(inputIsActive);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        return;
                    }
                    boolean inputIsActiveBol;
                    inputIsActiveBol = checkInt == 1;
                    isUpdated = updateUserModel.updateIsActive(email, inputIsActiveBol);
                    printUpdateStatus(isUpdated);
                    return;
                case "4":
                    System.out.println("Input new isAdmin status (0 - false, 1 - true): ");
                    String inputIsAdmin  = scanner.nextLine().trim();
                    try {
                        checkInt = Integer.parseInt(inputIsAdmin);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        return;
                    }
                    boolean inputIsAdminBol;
                    inputIsAdminBol = checkInt == 1;
                    isUpdated = updateUserModel.updateIsAdmin(email, inputIsAdminBol);
                    printUpdateStatus(isUpdated);
                    return;
                case "5":
                    System.out.println("Input new phone: ");
                    String inputPhone  = scanner.nextLine().trim();
                    isUpdated = updateUserModel.updatePhone(email, inputPhone);
                    printUpdateStatus(isUpdated);
                    return;
                case "6":
                    System.out.println("Input new name: ");
                    String inputName  = scanner.nextLine().trim();
                    isUpdated = updateUserModel.updateName(email, inputName);
                    printUpdateStatus(isUpdated);
                    return;
                case "7":
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }


    }

    private void printUpdateStatus(boolean isUpdated) {
        if (isUpdated) {
            System.out.println("Update successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }
    public void updateShow (Scanner scanner) {
        System.out.println("Please enter your credential: ");

        System.out.print("Enter Email: ");
        email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        Hashtable<Boolean, List<String>> authentificationResult = updateUserModel.authentificationProcessing(
                email, password
        );
        if  (!authentificationResult.containsKey(true)) {
            System.out.println("Error exist: ");
            authentificationResult.get(false).forEach(System.out::println);
            return;
        }
        updateProduct(scanner);
    }
}
