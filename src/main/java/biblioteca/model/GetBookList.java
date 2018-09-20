package biblioteca.model;

import java.util.*;

public class GetBookList {
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    public GetBookList(){
        book1 = new Book(new Title("book1"), new Author("Author1"), new Year(2010));
        book2 = new Book(new Title("book2"), new Author("Author2"), new Year(2011));
        book3 = new Book(new Title("book3"), new Author("Author3"), new Year(2012));
        book4 = new Book(new Title("book4"), new Author("Author4"), new Year(2013));
    }

    public Collection<Book> getBookList(){
        return Arrays.asList(book1, book2, book3, book4);
    }
}