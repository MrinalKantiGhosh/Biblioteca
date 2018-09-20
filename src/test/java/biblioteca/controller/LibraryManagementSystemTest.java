package biblioteca.controller;

import biblioteca.model.*;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagementSystemTest {
    Title title1;
    Title title2;
    Author author1;
    Author author2;
    Year year1;
    Year year2;
    Book book1;
    Book book2;
    List<Book> books;
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
        books = Arrays.asList(book1, book2);
        expectedTitles = Arrays.asList(title1, title2);
        expectedAuthors = Arrays.asList(author1, author2);
        expectedYears = Arrays.asList(year1, year2);
        library = new Library(books);
    }

    @DisplayName("test of welcome message along with list of books present")
    @Test
    void testStart(){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new OutputDriver(), library);
        libraryManagementSystem.start();
    }

}