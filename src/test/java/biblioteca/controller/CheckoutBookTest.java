package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
    @DisplayName("check performCommand for successful checkout of book")
    @Test
    void testForPerformActionForSuccessfulCheckoutOfBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutBook checkoutBook = new CheckoutBook();

        when(inputDriver.getInputBookName()).thenReturn("Book1");
        when(library.isContains(new Book(new Title("Book1")))).thenReturn(true);
        checkoutBook.performCommand(library, outputDriver, inputDriver);
        verify(library).checkoutBook(new Book(new Title("Book1")));
        verify(outputDriver).print(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for unsuccessful checkout of book")
    @Test
    void testForPerformActionForUnSuccessfulCheckoutOfBook(){
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutBook checkoutBook = new CheckoutBook();

        when(inputDriver.getInputBookName()).thenReturn("Book1");
        when(library.isContains(new Book(new Title("Book1")))).thenReturn(false);
        checkoutBook.performCommand(library, outputDriver, inputDriver);
        verify(library, times(0)).checkoutBook(new Book(new Title("Book1")));
        verify(outputDriver).print(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }
}