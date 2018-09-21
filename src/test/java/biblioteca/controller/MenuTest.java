package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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
        //library = new Library(Arrays.asList(book));
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
    }

    @DisplayName("check perform action for List books")
    @Test
    void testPerformActionForListBook(){
        library = mock(Library.class);
        menu = Menu.LIST_BOOKS;
        menu.performAction(library, outputDriver, inputDriver);
        verify(outputDriver).printListOfBooks(library.getBookDetails());

    }

    @DisplayName("check perform action for successful checkout")
    @Test
    void testPerformActionForSuccessfulCheckout(){
        library = mock(Library.class);
        menu = Menu.CHECKOUT;

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.isContains(new Book(new Title("book1")))).thenReturn(true);
        menu.performAction(library, outputDriver, inputDriver);
        verify(library).checkoutBook(new Book(new Title("book1")));
        verify(outputDriver).print(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful checkout")
    @Test
    void testPerformActionForUnsuccessfulCheckout(){
        library = mock(Library.class);
        menu = Menu.CHECKOUT;

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.isContains(new Book(new Title("book1")))).thenReturn(false);
        menu.performAction(library, outputDriver, inputDriver);
        verify(library, times(0)).checkoutBook(new Book(new Title("book1")));
        verify(outputDriver).print(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }

    @DisplayName("check perform action for successful return")
    @Test
    void testPerformActionForSuccessfulReturn(){
        library = mock(Library.class);
        //Menu returnMenu = Menu.RETURN;
        menu = Menu.RETURN;

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.hasChecked(new Book(new Title("book1")))).thenReturn(true);
        menu.performAction(library, outputDriver, inputDriver);
        verify(outputDriver).print(Messages.SUCCESSFULL_RETURN_MESSAGE);
    }

    @DisplayName("check perform action for unsuccessful return")
    @Test
    void testPerformActionForUnsuccessfulReturn(){
        library = mock(Library.class);
        //Menu returnMenu = Menu.RETURN;
        menu = Menu.RETURN;

        when(inputDriver.getInputBookName()).thenReturn("book1");
        when(library.hasChecked(new Book(new Title("book1")))).thenReturn(false);
        menu.performAction(library, outputDriver, inputDriver);
        verify(outputDriver).print(Messages.UNSUCCESSFULL_RETURN_MESSAGE);
    }

}