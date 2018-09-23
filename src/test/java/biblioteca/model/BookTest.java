package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Title title1;
    Title title2;
    Person person1;
    Person person2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;

    @BeforeEach
    void init(){
        title1 = new Title("book1");
        title2 = new Title("book2");
        person1 = new Person("person1");
        person2 = new Person("person2");
        year1 = new Year(2010);
        year2 = new Year(2012);
        book1 = new Book(title1, person1, year1);
        book2 = new Book(title2, person2, year2);
    }

    @DisplayName("should return true for two same book object")
    @Test
    void returnTrueForSameBookObject(){
        Book newBook = new Book(title1, person1, year1);
        assertEquals(newBook, book1);
    }

    @DisplayName("should not return true for two different book object")
    @Test
    void returnFalseForDifferentBookObject(){
        assertNotEquals(book2, book1);
    }
}