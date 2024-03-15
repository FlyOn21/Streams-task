package app.utils;

import app.entitys.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchUser {

    public List<User> search(LinkedHashMap<String, User> users, String findData, String searchType) {
        Function<User, String> searchFunction = switch (searchType) {
            case "username" -> User::getUsername;
            case "email" -> User::getEmail;
            case "phone" -> User::getPhone;
            default -> user -> "";
        };
        return searchAction(searchFunction, users, findData);
    }

    private List<User> searchAction(Function<User, String> actionFunc, LinkedHashMap<String, User> users, String findData) {
        return users.values().stream().filter(
                user -> actionFunc.apply(user).contains(findData)).collect(Collectors.toList());
    }
}
