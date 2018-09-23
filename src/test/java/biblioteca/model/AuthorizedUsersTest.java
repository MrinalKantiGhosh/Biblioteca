package biblioteca.model;

import biblioteca.model.repository.UserRepository;
import biblioteca.model.valueObjects.Password;
import biblioteca.model.valueObjects.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizedUsersTest {
    AuthorizedUsers authorizedUsers;
    User validUser;
    User unvalidUser;
    @BeforeEach
    void init(){
        authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());
        validUser = new User(new UserId("def-5678"), new Password("def"));
        unvalidUser = new User(new UserId("dfa-3453"), new Password("233"));
    }

    @DisplayName("return true when user is log in")
    @Test
    void returnTrueForSuccessfulLogOut(){
        authorizedUsers.logIn(validUser);
        assertTrue(authorizedUsers.logout(validUser));
    }

    @DisplayName("return false when un-valid user try to log in")
    @Test
    void returnFalseForUnSuccessfulLogOut(){
        assertFalse(authorizedUsers.logout(validUser));
    }

    @DisplayName("return true if user is already logged in")
    @Test
    void returnTrueIfAlreadyLoggedIn(){
        authorizedUsers.logIn(validUser);
        assertTrue(authorizedUsers.isLoggedIn());
    }

    @DisplayName("return false if user is not logged in")
    @Test
    void returnFalseIfNotLoggedIn(){
        assertFalse(authorizedUsers.isLoggedIn());
    }
}