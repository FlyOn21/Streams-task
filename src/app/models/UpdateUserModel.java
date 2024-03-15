package app.models;

import app.entitys.User;
import app.utils.AuthentificationUser;
import app.utils.UserCsv;
import app.utils.Validators;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;

public class UpdateUserModel {
    private final UserCsv userCsv = new UserCsv();

    private LinkedHashMap<String, User> users;

    public Hashtable<Boolean, List<String>> authentificationProcessing(String email, String password) {
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

    public boolean updateUsername(String email, String username) {
        return updateProductAttribute(email, user -> user.setUsername(username));
    }

    public boolean updatePassword(String email, String password) {
        return updateProductAttribute(email, user -> user.setPasswordHash(password));
    }

    public boolean updateIsActive(String email, boolean newStatus) {
        return updateProductAttribute(email, user -> user.setActive(newStatus));
    }

    public boolean updateIsAdmin(String email, boolean newStatus) {
        return updateProductAttribute(email, user -> user.setAdmin(newStatus));
    }

    public boolean updatePhone(String email, String newPhone) {
        if (!Validators.isValidPhoneNumber(newPhone)) {
            System.out.println("Phone number not valid");
            return false;
        }
        return updateProductAttribute(email, user -> user.setPhone(newPhone));
    }

    public boolean updateName(String email, String newName) {
        return updateProductAttribute(email, user -> user.setName(newName));
    }



    private boolean updateProductAttribute(String email, Consumer<User> updateFunction) {
        boolean isUpdated = false;
        try {
            User user = users.get(email);
            if (email != null) {
                updateFunction.accept(user);
                userCsv.writeCsv(users);
                isUpdated = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
