package biblioteca.model;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.valueObjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    Book book1;
    Book book2;
    @BeforeEach
    void init(){
        user = new User(new UserId("abc-1234"), new Password("abcd"));
        book1 = new Book(new Title("book1"), new Person("Author"), new Year(2010));
        book2 = new Book(new Title("book2"), new Person("Author"), new Year(2010));
    }

    @DisplayName("return true after successful return of a libraryItem")
    @Test
    void returnTrueFOrSuccessfulReturn(){
        user.checkoutItem(book1);
        assertEquals(book1, user.returnItem(book1));
    }

    @DisplayName("return false after unsuccessful return of a libraryItem which is not present in checklist")
    @Test
    void returnFalseForUnsuccessfulReturn(){
        user.checkoutItem(book1);
        assertNotEquals(book2, user.returnItem(book1));
    }
}