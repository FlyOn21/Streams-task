package app.utils;

import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    static BiPredicate<String, String> isValid = (checkData, regexPattern) -> checkData != null && !checkData.isEmpty() && isValidProcessing(checkData, regexPattern);

    public static boolean isValidEmail(String email) {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return isValid.test(email, EMAIL_REGEX);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        final String PHONE_REGEX = "\\(?\\+[0-9]{1,3}\\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})?"; // standard E.164
        return isValid.test(phoneNumber, PHONE_REGEX);
    }

    private static boolean isValidProcessing(String checkData, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(checkData);
        return matcher.matches();
    }



}
