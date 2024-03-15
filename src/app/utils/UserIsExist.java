package app.utils;
import app.entitys.User;

import java.util.LinkedHashMap;
import java.util.function.BiPredicate;

public class UserIsExist {
    private static boolean isExistUser(String email, LinkedHashMap<String, User> users) {
        boolean flag = true;
            if (users.containsKey(email)) {
                return flag;
            }
            return !flag;
    }

    public static BiPredicate<String, LinkedHashMap<String, User>> userIsExist = UserIsExist::isExistUser;
}
