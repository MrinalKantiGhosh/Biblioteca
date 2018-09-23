package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.controller.command.CheckoutItem;
import biblioteca.controller.command.ReturnItem;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnItemTest {
    @DisplayName("check perform action for successful return of book")
    @Test
    void testPerformActionForSuccessfulReturnOfBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ReturnItem returnItem = new ReturnItem(ItemType.BOOK);

        when(inputDriver.getInputItemName()).thenReturn("book1");
        when(library.returnItem("book1", ItemType.BOOK)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of book")
    @Test
    void testPerformActionForUnSuccessfulReturnOfBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ReturnItem returnItem = new ReturnItem(ItemType.BOOK);

        when(inputDriver.getInputItemName()).thenReturn("book1");
        when(library.returnItem("book1", ItemType.BOOK)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for successful return of movie")
    @Test
    void testPerformActionForSuccessfulReturnOfMovie(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ReturnItem returnItem = new ReturnItem(ItemType.MOVIE);

        when(inputDriver.getInputItemName()).thenReturn("movie1");
        when(library.returnItem("movie1", ItemType.MOVIE)).thenReturn(Messages.SUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return of movie")
    @Test
    void testPerformActionForUnsuccessfulReturnOfMovie(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ReturnItem returnItem = new ReturnItem(ItemType.MOVIE);

        when(inputDriver.getInputItemName()).thenReturn("movie1");
        when(library.returnItem("movie1", ItemType.MOVIE)).thenReturn(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
        returnItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_RETURN_MESSAGE);
    }
}