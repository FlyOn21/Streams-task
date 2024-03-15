package app.models;

import app.entitys.User;
import app.utils.AuthentificationUser;
import app.utils.SearchUser;
import app.utils.UserCsv;

import java.io.IOException;
import java.util.*;

public class UserExplorerModel {



    public List<User> allUsersGet() {
        UserCsv workWithCsv = new UserCsv();
        try{
            LinkedHashMap<String, User> usersData = workWithCsv.getDataCsv();
            return new ArrayList<>(usersData.values());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public AbstractMap.SimpleEntry<List<User>, List<String>> specificUserGet(String email, String password) {
        UserCsv workWithCsv = new UserCsv();
        try{
            LinkedHashMap<String, User> usersData = workWithCsv.getDataCsv();
            Hashtable<Boolean, List<String>> loginResult = AuthentificationUser.loginProcessing(email, password, usersData);
            if (loginResult.get(false) != null) {
                return new AbstractMap.SimpleEntry<>(new ArrayList<>(), loginResult.get(false));
            }
            List<User> userReturn = new ArrayList<>();
            userReturn.add(usersData.get(email));
            return new AbstractMap.SimpleEntry<>(userReturn, loginResult.get(true));

        } catch (IOException e) {
            e.printStackTrace();
            return new AbstractMap.SimpleEntry<>(new ArrayList<>(), List.of("Some problem, please try again later"));
        }
    }

    public List<User> searchUsers(String findData, String searchType) {
        UserCsv workWithCsv = new UserCsv();
        SearchUser searchUser = new SearchUser();
        try{
            LinkedHashMap<String, User> usersData = workWithCsv.getDataCsv();
            return searchUser.search(usersData, findData, searchType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
