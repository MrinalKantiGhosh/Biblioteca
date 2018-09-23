package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class AuthorizedUsers {
    private final List<User> validUsers;
    private final List<User> loggedInUsers;

    public AuthorizedUsers(List<User> validUsers) {
        this.validUsers = validUsers;
        this.loggedInUsers = new ArrayList<>();
    }

    public boolean isValidUser(User user){
        return validUsers.contains(user);
    }

    public boolean isLoggedIn(){
        return !loggedInUsers.isEmpty();
    }

    public void logIn(User user){
        loggedInUsers.add(user);
    }

    public boolean logout(User user){
        return loggedInUsers.remove(user);
    }
}