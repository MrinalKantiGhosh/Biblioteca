package biblioteca.model;

import java.util.*;

public class BookRepository {
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    public BookRepository(){
        book1 = new Book(new Title("book1"), new Person("Author1"), new Year(2010));
        book2 = new Book(new Title("book2"), new Person("Author2"), new Year(2011));
        book3 = new Book(new Title("book3"), new Person("Author3"), new Year(2012));
        book4 = new Book(new Title("book4"), new Person("Author4"), new Year(2013));
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