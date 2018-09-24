package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.controller.command.CheckoutItem;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.repository.UserRepository;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutItemTest {
    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    AuthorizedUsers authorizedUsers;
    User user;

    @BeforeEach
    void init(){
        authorizedUsers = mock(AuthorizedUsers.class);
        library = mock(Library.class);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        user = mock(User.class);
        when(authorizedUsers.fetchLoggedInUser()).thenReturn(user);
    }

    @DisplayName("check performCommand for successful checkout of book")
    @Test
    void testForPerformActionForSuccessfulCheckoutOfBook() {
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("book1");
        when(library.checkoutItem("book1", user, ItemType.BOOK)).thenReturn(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for unsuccessful checkout of book")
    @Test
    void testForPerformActionForUnSuccessfulCheckoutOfBook() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.BOOK);

        when(inputDriver.getInputString()).thenReturn("book1");
        when(library.checkoutItem("book1", user, ItemType.BOOK)).thenReturn(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for successful checkout of movie")
    @Test
    void testForPerformActionForSuccessfulCheckoutOfMovie() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.checkoutItem("movie1", user, ItemType.MOVIE)).thenReturn(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check performCommand for unsuccessful checkout of movie")
    @Test
    void testForPerformActionForUnSuccessfulCheckoutOfMovie() {
        Library library = mock(Library.class);
        OutputDriver outputDriver = mock(OutputDriver.class);
        InputDriver inputDriver = mock(InputDriver.class);
        CheckoutItem checkoutItem = new CheckoutItem(ItemType.MOVIE);

        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.checkoutItem("movie1", user, ItemType.MOVIE)).thenReturn(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        checkoutItem.performCommand(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }
}