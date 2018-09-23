package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.controller.command.CheckoutItem;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class CheckoutItemTest {

    @DisplayName("check performCommand for successful checkout of book")
    @Test
    void testForPerformActionForSuccessfulCheckoutOfBook() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.BOOK);

        when(inputDriver.getInputItemName()).thenReturn("book1");
        when(library.checkoutItem("book1", ItemType.BOOK)).thenReturn(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for unsuccessful checkout of book")
    @Test
    void testForPerformActionForUnSuccessfulCheckoutOfBook() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.BOOK);

        when(inputDriver.getInputItemName()).thenReturn("book1");
        when(library.checkoutItem("book1", ItemType.BOOK)).thenReturn(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for successful checkout of movie")
    @Test
    void testForPerformActionForSuccessfulCheckoutOfMovie() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.MOVIE);

        when(inputDriver.getInputItemName()).thenReturn("movie1");
        when(library.checkoutItem("movie1", ItemType.MOVIE)).thenReturn(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for unsuccessful checkout of movie")
    @Test
    void testForPerformActionForUnSuccessfulCheckoutOfMovie() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.MOVIE);

        when(inputDriver.getInputItemName()).thenReturn("movie1");
        when(library.checkoutItem("movie1", ItemType.MOVIE)).thenReturn(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }
}