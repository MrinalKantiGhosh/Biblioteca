package biblioteca.model;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.libraryItems.Movie;
import biblioteca.model.valueObjects.Password;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static biblioteca.common.Messages.*;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Book book1;
    private Book book2;
    private Movie movie1;
    private Movie movie2;
    private List<LibraryItem> items;
    private List<LibraryItem> checkedItems;
    private Library library;
    User user;

    @BeforeEach
    void init() {
        book1 = new Book(new Name("book1"));
        book2 = new Book(new Name("book2"));
        Movie movie1 = new Movie(new Name("movie1"));
        Movie movie2 = new Movie(new Name("movie2"));
        items = new ArrayList<>();
        checkedItems = new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(movie2);
        library = new Library(items);
        user = new User(new UserId("abc-1234"), new Password("abc"));
    }

    @DisplayName("expected to be remove specific given item object from list of library")
    @Test
    void testForCheckoutBookFromList() {
        assertTrue(items.contains(book1));
        assertEquals(SUCCESSFUL_CHECKOUT_MESSAGE, library.checkoutItem("book1", user, ItemType.BOOK));
    }

    @DisplayName("expected not to be remove specific given item object from list of library which is not present")
    @Test
    void falseForCheckoutBookFromList() {
        assertFalse(items.contains(movie2));
        assertEquals(UNSUCCESSFUL_CHECKOUT_MESSAGE, library.checkoutItem("movie1", user, ItemType.MOVIE));
    }

    @DisplayName("expected to be return specific given item to the library")
    @Test
    void testForReturnBookTolibrary() {
        assertTrue(items.contains(book2));
        assertEquals(SUCCESSFUL_CHECKOUT_MESSAGE, library.checkoutItem("book2", user, ItemType.BOOK));
        assertFalse(items.contains(book2));
        assertEquals(SUCCESSFUL_RETURN_MESSAGE, library.returnItem("book2", user, ItemType.BOOK));
    }

    @DisplayName("expected not to be return specific given item to the library which is not valid")
    @Test
    void falseForReturnBookFromListWhichIsNotValid() {
        assertFalse(items.contains(movie1));
        assertEquals(UNSUCCESSFUL_RETURN_MESSAGE, library.returnItem("movie1", user, ItemType.MOVIE));
    }


}