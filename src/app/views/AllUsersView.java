package app.views;

import app.entitys.User;
import app.models.UserExplorerModel;
import app.utils.Printer;

import java.util.List;

public class AllUsersView {
    private final UserExplorerModel allUsersModel = new UserExplorerModel();

    public void showAllUsers() {
        List<User> users = allUsersModel.allUsersGet();
        if (users.isEmpty()) {
            System.out.println("There is no users");
            return;
        }
        Printer.printUser(users, false);
    }

}
