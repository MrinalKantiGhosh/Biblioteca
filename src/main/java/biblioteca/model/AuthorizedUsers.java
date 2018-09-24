package biblioteca.model;

import java.util.List;

public class AuthorizedUsers {
    private final List<User> validUsers;
    private User loggedInUser;

    public AuthorizedUsers(List<User> validUsers) {
        this.validUsers = validUsers;
        loggedInUser = null;
    }

    public boolean isValidUser(User user) {
        return validUsers.contains(user);
    }

    public boolean isLoggedIn() {
        return !(loggedInUser == null);
    }

    public User fetchLoggedInUser() {
        return loggedInUser;
    }

    public void logIn(User user) {
        loggedInUser = validUsers.get(validUsers.indexOf(user));
    }

    public void logout() {
        loggedInUser = null;
    }
}