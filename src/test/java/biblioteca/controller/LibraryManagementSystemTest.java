package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    Title title1;
    Title title2;
    Person person1;
    Person person2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;
    Movie movie1;
    Movie movie2;
    List<LibraryItem> books;
    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;
    LibraryManagementSystem libraryManagementSystem;
    @BeforeEach
    void init(){
        library = mock(Library.class);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(library, outputDriver, inputDriver);
    }

    @DisplayName("zero interactions before calling start method")
    @Test
    void testZeroInteractionBeforeInvokingStart(){
        verifyZeroInteractions(outputDriver);
    }

    @DisplayName("show exit checking from menu")
    @Test
    void testForExitFromMenu(){
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).print(Messages.EXIT_MESSAGE);
    }

    @DisplayName("for showing list of books")
    @Test
    void testForShowingListBook(){
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(1).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).printListOfItems(library.getLibraryItemDetails(ItemType.BOOK));
    }

    @DisplayName("test for invalid input option")
    @Test
    void testForValid(){
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(9).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).println(Messages.ASK_FOR_VALID_INPUT);
    }
}