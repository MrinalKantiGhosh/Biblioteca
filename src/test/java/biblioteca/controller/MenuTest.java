
package biblioteca.controller;

import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static biblioteca.common.Messages.*;
import static org.mockito.Mockito.*;


class MenuTest {
    private Menu menu;
    private InputDriver inputDriver;
    private OutputDriver outputDriver;
    private Library library;
    AuthorizedUsers authorizedUsers;
    User user;

    @BeforeEach
    void init(){
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        authorizedUsers = mock(AuthorizedUsers.class);
        user = mock(User.class);
        when(authorizedUsers.fetchLoggedInUser()).thenReturn(user);
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
    }

    @DisplayName("check perform action for List books")
    @Test
    void testPerformActionForListBook(){
        menu = Menu.LIST_BOOKS;
        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);
        verify(outputDriver).printListOfItems(library.getLibraryItemDetails(ItemType.BOOK));

    }

    @DisplayName("check perform action for successful checkout")
    @Test
    void testPerformActionForSuccessfulCheckout(){
        menu = Menu.CHECKOUT_BOOK;
        when(library.checkoutItem("book1", user, ItemType.BOOK)).thenReturn(SUCCESSFUL_CHECKOUT_MESSAGE);
        when(inputDriver.getInputString()).thenReturn("book1");
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful checkout")
    @Test
    void testPerformActionForUnsuccessfulCheckout(){
        menu = Menu.CHECKOUT_MOVIE;
        when(library.checkoutItem("movie1", user, ItemType.MOVIE)).thenReturn(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        when(inputDriver.getInputString()).thenReturn("movie1");
        when(authorizedUsers.isLoggedIn()).thenReturn(true);

        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check perform action for successful return")
    @Test
    void testPerformActionForSuccessfulReturn(){
        menu = Menu.RETURN_MOVIE;
        when(inputDriver.getInputString()).thenReturn("movie1");
        when(library.returnItem("movie1", user, ItemType.MOVIE)).thenReturn(SUCCESSFUL_RETURN_MESSAGE);
        when(authorizedUsers.isLoggedIn()).thenReturn(true);
        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(SUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return")
    @Test
    void testPerformActionForUnsuccessfulReturn(){
        menu = Menu.RETURN_BOOK;
        when(library.returnItem("book1", user, ItemType.BOOK)).thenReturn(UNSUCCESSFUL_RETURN_MESSAGE);
        when(inputDriver.getInputString()).thenReturn("book1");
        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);

        verify(outputDriver).println(UNSUCCESSFUL_RETURN_MESSAGE);
    }

    @DisplayName("test Log in")
    @Test
    void checkLogIn(){
        menu = Menu.LOGIN;
        menu.performAction(library, outputDriver, inputDriver, authorizedUsers);
        verify(authorizedUsers).isLoggedIn();
    }

}