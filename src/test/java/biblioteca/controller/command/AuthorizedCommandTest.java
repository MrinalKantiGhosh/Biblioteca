package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class AuthorizedCommandTest {
    private Library library;
    private CheckoutItemCommand checkoutItemCommand;
    private AuthorizedUsers authorizedUsers;
    private AuthorizedCommand authorizedCommand;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    @BeforeEach
    @Test
    void init(){
        checkoutItemCommand = mock(CheckoutItemCommand.class);
        authorizedUsers = mock(AuthorizedUsers.class);
        authorizedCommand = new AuthorizedCommand(checkoutItemCommand);
        library = mock(Library.class);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
    }


    @DisplayName("check for successful authorization")
    @Test
    void checkSuccessfulAuthorization(){
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        authorizedCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(checkoutItemCommand).performCommand(library, outputDriver, inputDriver, authorizedUsers);
    }

    @DisplayName("check for unsuccessful authorization")
    @Test
    void checkUnsuccessfulAuthorization(){
        when(authorizedUsers.isLoggedIn()).thenReturn(false);
        authorizedCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.NOT_LOGGED_IN_YET);
    }
}