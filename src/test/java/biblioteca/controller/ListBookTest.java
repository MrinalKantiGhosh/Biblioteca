package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ListBookTest {
    @DisplayName("test for performAction of List Book")
    @Test
    void testForPerformActionOfListBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        ListBook listBook = new ListBook();

        listBook.performCommand(library, outputDriver, inputDriver);
        verify(library).getBookDetails();
    }
}