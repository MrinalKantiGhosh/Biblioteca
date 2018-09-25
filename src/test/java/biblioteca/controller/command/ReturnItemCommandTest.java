package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnItemCommandTest {
    Library library;
    OutputDriver outputDriver;
    InputDriver inputDriver;
    AuthorizedUsers authorizedUsers;
    User user;

    @BeforeEach
    void init(){
        library = mock(Library.class);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        user = mock(User.class);
        authorizedUsers = mock(AuthorizedUsers.class);
        when(authorizedUsers.fetchLoggedInUser()).thenReturn(user);
    }

    @DisplayName("check perform action for successful return of book")
    @Test
    void testPerformActionForSuccessfulReturnOfBook(){
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(ItemType.BOOK);
        when(inputDriver.getInputString()).thenReturn("book1");
        when(library.returnItem("book1", user, ItemType.BOOK)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);

        returnItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of book")
    @Test
    void testPerformActionForUnSuccessfulReturnOfBook(){
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(ItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("book1");
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        when(library.returnItem("book1", user, ItemType.BOOK)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for successful return of movie")
    @Test
    void testPerformActionForSuccessfulReturnOfMovie(){
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.returnItem("movie1", user, ItemType.MOVIE)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);
        returnItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of movie")
    @Test
    void testPerformActionForUnsuccessfulReturnOfMovie(){
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.returnItem("movie1", user, ItemType.MOVIE)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItemCommand.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }
}