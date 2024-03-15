package app.models;
import app.config.Config;
import app.entitys.User;
import app.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class CreateUserModel {
    private  final Hashtable<Boolean, List<String>> result = new Hashtable<>();
    private final boolean isCreate = false;
    private final List<String> errors = new ArrayList<>();

    private final String salt = PasswordValidation.generateSalt(Config.SALT_LENGTH);

    private final UserCsv workWithCsv = new UserCsv();


    public  Hashtable<Boolean, List<String>> createUser(
            String email,
            String password,
            String username,
            String name,
            String phone
    )
    {
        if (!Validators.isValidEmail(email)) {
            errors.add("Email not valid");
        }
        if (!Validators.isValidPhoneNumber(phone)) {
            errors.add("Phone number not valid");
        }
        if (!errors.isEmpty()) {
            result.put(isCreate, errors);
            return result;
        }
        LinkedHashMap<String, User> csvData;
        try{
            csvData = workWithCsv.getDataCsv();
        } catch (IOException e) {
            e.printStackTrace();
            errors.add("Error with db data");
            result.put(isCreate, errors);
            return result;
        }
        if (UserIsExist.userIsExist.test(email, csvData)){
            errors.add("User already exist");
            result.put(isCreate, errors);
            return result;
        }
        User user = new User(
                email,
                username,
                phone,
                name,
                salt,
                PasswordValidation.hashPassword(password, salt),
                true,
                false,
                GetTimestamp.getTimestamp(),
                GetTimestamp.getTimestamp()
        );
        csvData.put(email, user);
        try{
            workWithCsv.writeCsv(csvData);
        } catch (IOException e) {
            e.printStackTrace();
            errors.add("Error with db data");
            result.put(isCreate, errors);
            return result;
        }
        result.put(!isCreate, errors);
        return result;
    }

}
