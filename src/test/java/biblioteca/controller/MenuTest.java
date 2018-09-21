package biblioteca.controller;

import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.mockito.Mockito.*;


class MenuTest {
    private Menu menu;
    private Title title;
    private Author author;
    private Year yearOfPublish;
    private Book book;
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;

    @BeforeEach
    void init(){
        title = new Title("Book");
        author = new Author("Author");
        yearOfPublish = new Year(2010);
        Book book = new Book(title, author, yearOfPublish);
        library = new Library(Arrays.asList(book));
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
    }

    @DisplayName("check perform action for List books")
    @Test
    void testPerformActionForListBook(){
        menu = Menu.LIST_BOOKS;
        menu.performAction(library, outputDriver);
        verify(outputDriver).printListOfBooks(library.getBookDetails());

    }

}