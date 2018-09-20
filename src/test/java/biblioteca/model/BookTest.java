package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Title title1;
    Title title2;
    Author author1;
    Author author2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;

    @BeforeEach
    void init(){
        title1 = new Title("book1");
        title2 = new Title("book2");
        author1 = new Author("author1");
        author2 = new Author("author2");
        year1 = new Year(2010);
        year2 = new Year(2012);
        book1 = new Book(title1, author1, year1);
        book2 = new Book(title2, author2, year2);
    }

    @DisplayName("expect BookTest title, AuthorTest as author and 2010 as year of publish")
    @Test
    void testOfGettingBookDetails(){
        //Book book = new Book(new Title("BookTest"), new Author("AuthorTest"), new Year(2010));

        assertAll(()->{
            assertEquals(title1, book1.getTitle());
            assertEquals(author1, book1.getAuthor());
            assertEquals(year1, book1.getYear());
        });
    }

    @DisplayName("should return true for two same book object")
    @Test
    void returnTrueForSameBookObject(){
        Book newBook = new Book(title1, author1, year1);
        assertEquals(newBook, book1);
    }

    @DisplayName("should not return true for two different book object")
    @Test
    void returnFalseForDifferentBookObject(){
        assertNotEquals(book2, book1);
    }
}