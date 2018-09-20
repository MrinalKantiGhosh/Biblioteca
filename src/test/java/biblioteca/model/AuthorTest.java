package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    @DisplayName("expect AuthorTest as author")
    @Test
    void testForGetAuthor(){
        Author author = new Author("AuthorTest");
        assertEquals("AuthorTest", author.getValue());
    }

    @DisplayName("return true for two same author object")
    @Test
    void returnTrueForTwoSameAuthorObject(){
        Author author1 = new Author("Author1");
        Author author2 = new Author("Author1");
        assertEquals(author1, author2);
    }

    @DisplayName("return not true for two different author object")
    @Test
    void returnTrueForTwoDifferentAuthorObject(){
        Author author1 = new Author("Author1");
        Author author2 = new Author("Author2");
        assertNotEquals(author1, author2);
    }
}