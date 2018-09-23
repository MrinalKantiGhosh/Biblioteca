package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.controller.command.ReturnItem;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnItemTest {
    Library library;
    OutputDriver outputDriver;
    InputDriver inputDriver;
    AuthorizedUsers authorizedUsers;

    @BeforeEach
    void init(){
        library = mock(Library.class);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
    }

    @DisplayName("check perform action for successful return of book")
    @Test
    void testPerformActionForSuccessfulReturnOfBook(){

        ReturnItem returnItem = new ReturnItem(ItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("book1");
        when(library.returnItem("book1", ItemType.BOOK)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of book")
    @Test
    void testPerformActionForUnSuccessfulReturnOfBook(){
        ReturnItem returnItem = new ReturnItem(ItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("book1");
        when(library.returnItem("book1", ItemType.BOOK)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for successful return of movie")
    @Test
    void testPerformActionForSuccessfulReturnOfMovie(){
        ReturnItem returnItem = new ReturnItem(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.returnItem("movie1", ItemType.MOVIE)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of movie")
    @Test
    void testPerformActionForUnsuccessfulReturnOfMovie(){
        ReturnItem returnItem = new ReturnItem(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.returnItem("movie1", ItemType.MOVIE)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }
}