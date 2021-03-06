package biblioteca.model.repository;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.Year;

import java.util.*;

public class BookRepository {
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    public BookRepository(){
        book1 = new Book(new Name("book1"), new Person("Author1"), new Year(2010));
        book2 = new Book(new Name("book2"), new Person("Author2"), new Year(2011));
        book3 = new Book(new Name("book3"), new Person("Author3"), new Year(2012));
        book4 = new Book(new Name("book4"), new Person("Author4"), new Year(2013));
    }

    public List<LibraryItem> getBooks(){
        ArrayList<LibraryItem> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        return books;
    }
}