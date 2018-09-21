package biblioteca.model;

import java.util.Objects;

public class Book {
    private final Title title;
    private final Author author;
    private final Year year;


    public Book(Title title, Author author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(Title title){
        this(title, new Author(""), new Year(0));
    }

    Title getTitle() {
        return title;
    }

    Author getAuthor() {
        return author;
    }

    Year getYear() {
        return year;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }
}
