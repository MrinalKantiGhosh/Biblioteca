package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LogOutCommandTest {
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

    @DisplayName("check log out when not logged into the system")
    @Test
    void checkForNotLoggedInTheSystem(){
        LogOutCommand logOutCommand = new LogOutCommand();

        when(authorizedUsers.isLoggedIn()).thenReturn(false);
        logOutCommand.performCommand(library, outputDriver,inputDriver, authorizedUsers);
        verify(outputDriver).println(Messages.NOT_LOGGED_IN_YET);
    }

    @DisplayName("check for logged into the system")
    @Test
    void checkForLogOutFromTheSystem(){
        LogOutCommand logOutCommand = new LogOutCommand();

        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        logOutCommand.performCommand(library, outputDriver,inputDriver, authorizedUsers);
        verify(outputDriver).println(Messages.SUCCESSFUL_LOG_OUT);
    }
}