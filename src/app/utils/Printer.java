package app.utils;

import app.entitys.User;

import java.util.List;

public class Printer {
    public static void printUser(List<User> users, boolean printAll) {
        if (printAll) {
            printAllData(users);
        } else {
            printSharedData(users);
        }
    }
    private static void printAllData(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> {
            String userInfo = """
                =================== User Name: %s ===================
                Email: %s
                Phone: %s
                Name: %s
                Salt: %s
                IsActive: %s
                IsAdmin: %s
                Creation Timestamp: %s
                Last Update Timestamp: %s
                
                """.formatted(
                    user.getUsername(), user.getEmail(), user.getPhone(), user.getName(),
                    user.getSalt(), user.isActive() ? "Yes" : "No", user.isAdmin() ? "Yes" : "No",
                    user.getCreateTimestamp(), user.getUpdateTimestamp());
            sb.append(userInfo);
        });
        System.out.println(sb);
    }

    private static void printSharedData(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> {
            String userInfo = """
                =================== User Name: %s ===================
                Email: %s
                Phone: %s
                
                """.formatted(user.getUsername(), user.getEmail(), user.getPhone());
            sb.append(userInfo);
        });
        System.out.println(sb);
    }
}
