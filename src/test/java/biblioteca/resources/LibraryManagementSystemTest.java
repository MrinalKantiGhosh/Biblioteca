package biblioteca.resources;

import biblioteca.common.Messages;
import biblioteca.common.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    OutputDriver outputDriver;
    LibraryManagementSystem libraryManagementSystem;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    List<Book> listOfBooks;

    @BeforeEach
    void init(){
        outputDriver = mock(OutputDriver.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
        book4 = mock(Book.class);
        book5 = mock(Book.class);
        when(book1.toString()).thenReturn("book1");
        when(book2.toString()).thenReturn("book2");
        when(book3.toString()).thenReturn("book3");
        when(book4.toString()).thenReturn("book4");
        when(book5.toString()).thenReturn("book5");
        listOfBooks = Arrays.asList(book1, book2, book3, book4);
        libraryManagementSystem = new LibraryManagementSystem(outputDriver, listOfBooks);
    }

    @DisplayName("check print functionality of output driver ")
    @Test
    void checkPrintFunctionality(){
        verify(outputDriver, times(1)).print(Messages.WELCOME_MESSAGE);
    }

    @DisplayName("show list of books after showing welcome message")
    @Test
    void checkDisplayBooksFunctionality(){
        verify(outputDriver, times(1)).print("book1");
        verify(outputDriver, times(1)).print("book2");
        verify(outputDriver, times(1)).print("book3");
        verify(outputDriver, times(1)).print("book4");
    }

    @DisplayName("don't show the books which are not in list")
    @Test
    void checkDisplayBooksFunctionalityWhenBookIsNotInList(){
        verify(outputDriver, times(0)).print("book5");
    }
}