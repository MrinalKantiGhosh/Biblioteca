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
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }
}
