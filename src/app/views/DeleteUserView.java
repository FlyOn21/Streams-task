package app.views;

import app.models.DeleteUserModel;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class DeleteUserView {
    private final DeleteUserModel deleteUserModel = new DeleteUserModel();
    private boolean deleteCompleted;
    public void showDelete (Scanner scanner) {
        System.out.println("Please enter your credential: ");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();


        Hashtable<Boolean, List<String>> authentificationResult = deleteUserModel.authentificationProcessing(
                email, password
        );
        if  (!authentificationResult.containsKey(true)) {
            System.out.println("Error exist: ");
            authentificationResult.get(false).forEach(System.out::println);
            return;
        }
        boolean isDelete = userChoiceConfirmation(scanner);
        if (isDelete) {
            deleteCompleted = deleteUserModel.deleteUser(email);
        }
        if (isDelete && deleteCompleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not deleted.");
        }

    }

    private boolean userChoiceConfirmation(Scanner scanner) {
        System.out.println("Are you sure you want to delete this user? (Y/N)");
        String choice = scanner.nextLine().trim();
        return choice.equalsIgnoreCase("Y");
    }
}
