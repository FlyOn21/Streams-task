package app.models;

import app.entitys.User;
import app.utils.AuthentificationUser;
import app.utils.UserCsv;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class DeleteUserModel {

    private final UserCsv userCsv = new UserCsv();

    public Hashtable<Boolean, List<String>> authentificationProcessing(String email, String password) {
        LinkedHashMap<String, User> users;
        try {
            users = userCsv.getDataCsv();
        } catch (IOException e) {
            e.printStackTrace();
            Hashtable<Boolean, List<String>> error = new Hashtable<>();
            error.put(false, List.of("Some problem, please try again later"));
            return error;
        }
        return AuthentificationUser.loginProcessing(
                email,
                password,
                users
        );
    }

    public boolean deleteUser(String email) {
        boolean isDeleted = false;
        try
        {
            LinkedHashMap<String, User> users = userCsv.getDataCsv();
            if (users.containsKey(email)) {
                users.remove(email);
                userCsv.writeCsv(users);
                return !isDeleted;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
