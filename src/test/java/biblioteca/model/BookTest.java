package biblioteca.model;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Name name1;
    Name name2;
    Person person1;
    Person person2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;

    @BeforeEach
    void init(){
        name1 = new Name("book1");
        name2 = new Name("book2");
        person1 = new Person("person1");
        person2 = new Person("person2");
        year1 = new Year(2010);
        year2 = new Year(2012);
        book1 = new Book(name1, person1, year1);
        book2 = new Book(name2, person2, year2);
    }

    @DisplayName("should return true for two same book1 object")
    @Test
    void returnTrueForSameBookObject(){
        Book newBook = new Book(name1, person1, year1);
        assertEquals(newBook, book1);
    }

    @DisplayName("should not return true for two different book1 object")
    @Test
    void returnFalseForDifferentBookObject(){
        assertNotEquals(book2, book1);
    }
}