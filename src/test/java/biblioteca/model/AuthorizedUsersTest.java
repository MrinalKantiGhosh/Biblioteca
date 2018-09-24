package biblioteca.model;

import biblioteca.model.repository.UserRepository;
import biblioteca.model.valueObjects.Password;
import biblioteca.model.valueObjects.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizedUsersTest {
    private AuthorizedUsers authorizedUsers;
    private User validUser;

    @BeforeEach
    void init() {
        authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());
        validUser = new User(new UserId("def-5678"), new Password("def"));
    }

    @DisplayName("return true if user is already logged in")
    @Test
    void returnTrueIfAlreadyLoggedIn() {
        authorizedUsers.logIn(validUser);
        assertTrue(authorizedUsers.isLoggedIn());
    }

    @DisplayName("return false if user is not logged in")
    @Test
    void returnFalseIfNotLoggedIn() {
        assertFalse(authorizedUsers.isLoggedIn());
    }

    @DisplayName("get current logged in user")
    @Test
    void fetchCurrentlyLoggedInUser() {
        authorizedUsers.logIn(validUser);
        assertEquals(validUser, authorizedUsers.fetchLoggedInUser());
    }
}