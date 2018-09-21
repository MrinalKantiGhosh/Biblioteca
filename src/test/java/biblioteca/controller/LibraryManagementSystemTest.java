package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    Title title1;
    Title title2;
    Author author1;
    Author author2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;
    List<Book> books;
    Library library;
    InputDriver inputDriver;
    OutputDriver outputDriver;

    @BeforeEach
    void init(){
        title1 = new Title("book1");
        title2 = new Title("book2");
        Author author1 = new Author("author1");
        Author author2 = new Author("author2");
        Year year1 = new Year(2010);
        Year year2 = new Year(2012);
        book1 = new Book(title1, author1, year1);
        book2 = new Book(title2, author2, year2);
        books = Arrays.asList(book1, book2);
        library = new Library(books);
        inputDriver = mock(InputDriver.class);
        outputDriver = mock(OutputDriver.class);
    }

    @DisplayName("zero interactions before calling start method")
    @Test
    void testZeroInteractionBeforeInvokingStart(){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library, inputDriver);
        verifyZeroInteractions(outputDriver);
    }

    @DisplayName("show exit checking from menu")
    @Test
    void testForExitFromMenu(){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library, inputDriver);
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(0);
        libraryManagementSystem.start();
    }

    @DisplayName("show exit checking from menu")
    @Test
    void testForShowingListBook(){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library, inputDriver);
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(1).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).printListOfBooks(library.getBookDetails());
    }

    @DisplayName("test for invalid input option")
    @Test
    void testForValid(){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library, inputDriver);
        when(inputDriver.getInputFromUserForSelectMenuOption()).thenReturn(5).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).print(Messages.ASK_FOR_VALID_INPUT);
    }

}