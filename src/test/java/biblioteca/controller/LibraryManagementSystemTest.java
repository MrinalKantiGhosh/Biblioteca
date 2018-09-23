package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.repository.UserRepository;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    LibraryManagementSystem libraryManagementSystem;
    @BeforeEach
    void init(){
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        AuthorizedUsers authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());

        libraryManagementSystem = new LibraryManagementSystem(library, outputDriver, inputDriver, authorizedUsers);
    }

    @DisplayName("zero interactions before calling start method")
    @Test
    void testZeroInteractionBeforeInvokingStart(){
        verifyZeroInteractions(outputDriver);
    }

    @DisplayName("show exit checking from menu")
    @Test
    void testForExitFromMenu(){
        when(inputDriver.getInputInteger()).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).println(Messages.EXIT_MESSAGE);
    }

    @DisplayName("for showing list of books")
    @Test
    void testForShowingListBook(){
        when(inputDriver.getInputInteger()).thenReturn(1).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).printListOfItems(library.getLibraryItemDetails(ItemType.BOOK));
    }

    @DisplayName("test for invalid input option")
    @Test
    void testForValid(){
        when(inputDriver.getInputInteger()).thenReturn(9).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).println(Messages.ASK_FOR_VALID_INPUT);
    }
}