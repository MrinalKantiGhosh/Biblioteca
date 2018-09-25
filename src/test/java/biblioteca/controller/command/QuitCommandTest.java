package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.model.repository.UserRepository;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class QuitCommandTest {
    @DisplayName("checking exit message")
    @Test
    void testExitMessage(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        QuitCommand quitCommand = new QuitCommand();
        AuthorizedUsers authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());


        quitCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.EXIT_MESSAGE);
    }

}