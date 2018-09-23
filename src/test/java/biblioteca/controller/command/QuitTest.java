package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.controller.Menu;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class QuitTest {
    @DisplayName("checking exit message")
    @Test
    void testExitMessage(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        Quit quit = new Quit();

        quit.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.EXIT_MESSAGE);
    }

}