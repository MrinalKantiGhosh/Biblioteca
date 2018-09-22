package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnBookTest {
    @DisplayName("check perform action for successful return")
    @Test
    void testPerformActionForSuccessfulReturn(){
        Library library = mock(Library.class);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        ReturnBook returnBook = new ReturnBook();

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.hasChecked(new Book(new Title("book1")))).thenReturn(true);
        returnBook.performCommand(library, outputDriver, inputDriver);
        verify(outputDriver).print(Messages.SUCCESSFULL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return")
    @Test
    void testPerformActionForUnsuccessfulReturn(){
        Library library = mock(Library.class);
        InputDriver inputDriver = mock(InputDriver.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        ReturnBook returnBook = new ReturnBook();

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.hasChecked(new Book(new Title("book1")))).thenReturn(false);
        returnBook.performCommand(library, outputDriver, inputDriver);
        verify(outputDriver).print(Messages.UNSUCCESSFULL_RETURN_MESSAGE);
    }
}