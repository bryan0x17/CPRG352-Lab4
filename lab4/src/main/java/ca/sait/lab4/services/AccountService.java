package ca.sait.lab4.services;

import ca.sait.lab4.model.User;


public class AccountService {
    public User login(String username, String password) {
        if ((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
            return new User(username, password);
        }
        return null;
    }
}
