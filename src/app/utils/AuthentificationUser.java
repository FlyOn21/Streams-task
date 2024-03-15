package app.utils;

import app.entitys.User;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class AuthentificationUser {

    public static Hashtable<Boolean, List<String>> loginProcessing(String email, String password, LinkedHashMap<String, User> users) {
        Hashtable<Boolean, List<String>> result = new Hashtable<>();
        List<String> errors = new ArrayList<>();
        if (!Validators.isValidEmail(email)) {
            errors.add("Invalid email");
            result.put(false, errors);
            return result;
        }
        if (!users.containsKey(email)) {
            errors.add("User not found");
            result.put(false, errors);
            return result;
        }
        User user = users.get(email);
        if (!PasswordValidation.validatePassword(password, user.getPasswordHash(), user.getSalt())) {
            errors.add("Invalid password");
            result.put(false, errors);
            return result;
        }
        result.put(true, errors);
        return result;
    }
}
