package biblioteca.model;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.valueObjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    Book book;
    @BeforeEach
    void init(){
        user = new User(new UserId("abc-1234"), new Password("abcd"));
        book = new Book(new Title("book"), new Person("Author"), new Year(2010));
    }

    @DisplayName("return true after successful return of a libraryItem")
    @Test
    void returnTrueFOrSuccessfulReturn(){
        user.checkoutItem(book);
        assertTrue(user.returnItem(book));
    }

    @DisplayName("return false after unsuccessful return of a libraryItem which is not present in checklist")
    @Test
    void returnFalseFOrUnsuccessfulReturn(){
        assertFalse(user.returnItem(book));
    }
}