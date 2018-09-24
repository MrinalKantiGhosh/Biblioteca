package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.common.Messages.*;
import static org.mockito.Mockito.*;

class LogInTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private AuthorizedUsers authorizedUsers;
    private User user;

    @BeforeEach
    void init(){
        library = mock(Library.class);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        authorizedUsers = mock(AuthorizedUsers.class);
        user = mock(User.class);
    }

    @DisplayName("expect already logged in")
    @Test
    void checkAlreadyLogIn(){
        LogIn logIn = new LogIn();
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        logIn.performCommand(library, outputDriver, inputDriver, authorizedUsers);
        verify(outputDriver).println(ALREADY_LOGGED_IN);

    }

    @DisplayName("expect Not a valid user")
    @Test
    void checkInvalidUser(){
        LogIn logIn = new LogIn();
        when(authorizedUsers.isLoggedIn()).thenReturn(false);
        when(authorizedUsers.isValidUser(user)).thenReturn(false);
        logIn.performCommand(library, outputDriver, inputDriver, authorizedUsers);
        verify(outputDriver).println(NOT_A_VALID_USER);

    }
}