package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Title title1;
    Title title2;
    Author author1;
    Author author2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;
    List<Book> books;
    List<Book> checkedBooks;
    List<Title> expectedTitles;
    List<Author> expectedAuthors;
    List<Year> expectedYears;
    Library library;

    @BeforeEach
    void init(){
        title1 = new Title("book1");
        title2 = new Title("book2");
        Author author1 = new Author("author1");
        Author author2 = new Author("author2");
        Year year1 = new Year(2010);
        Year year2 = new Year(2012);
        book1 = new Book(title1, author1, year1);
        book2 = new Book(title2, author2, year2);
        books = new ArrayList<>();
        checkedBooks = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        checkedBooks.add(book2);
        expectedTitles = Arrays.asList(title1, title2);
        expectedAuthors = Arrays.asList(author1, author2);
        expectedYears = Arrays.asList(year1, year2);
        library = new Library(books);
    }

    @DisplayName("expected book titles given is as same as we get in list")
    @Test
    void testGetTitleList(){
        List<Title> resultListOfTitle = library.getTitleFromListOfBooks();

        assertEquals(expectedTitles, resultListOfTitle);
    }

    @DisplayName("expected book authors given is as same as we get in list")
    @Test
    void testGetAuthorList(){
        List<Author> resultListOfAuthor = library.getAuthorFromListOfBooks();

        assertEquals(expectedAuthors, resultListOfAuthor);
    }

    @DisplayName("expected year of publish given is as same as we get in list")
    @Test
    void testGetYearOfPublishList(){
        List<Year> resultListOfYears = library.getYearOfPublishFromListOfBooks();

        assertEquals(expectedYears, resultListOfYears);
    }

    @DisplayName("expected to be remove specific given book object from book list of library")
    @Test
    void testForCheckoutBookFromBookList(){
        assertTrue(books.contains(book1));
        library.checkoutBook(book1);
        assertFalse(books.contains(book1));
    }

    @DisplayName("should return false for that book which is not present in books")
    @Test
    void testShouldReturnFalseForThatBookWhichIsNotPresentInList(){
        assertFalse(library.isContains(new Book(new Title("book3"))));
    }

    @DisplayName("should return true for that book which is present in books")
    @Test
    void testShouldReturnTrueForThatBookWhichIsPresentInCheckedoutList(){
        assertTrue(library.isContains(book1));
    }

    @DisplayName("should return false for that book which is not present in books")
    @Test
    void testShouldReturnFalseForThatBookWhichIsNotPresentInCheckedList(){
        assertFalse(library.hasChecked(new Book(new Title("book3"))));
    }

    @DisplayName("should return true for that book which is present in books")
    @Test
    void testShouldReturnTrueForThatBookWhichIsPresentInList(){
        assertFalse(library.hasChecked(book1));
        library.checkoutBook(book1);
        assertTrue(library.hasChecked(book1));
    }
}