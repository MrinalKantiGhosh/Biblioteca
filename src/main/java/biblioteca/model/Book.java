package biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements LibraryItem{
    private final Title title;
    private final Person author;
    private final Year year;
    ItemType type;


    public Book(Title title, Person author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = ItemType.BOOK;
    }

    public Book(Title title){
        this(title, new Person(""), new Year(0));
    }

    @Override
    public ItemType getItemType() {
        return this.type;
    }

    @Override
    public String getItemDetail() {
        return this.title.getValue() + "," + this.author.getValue() + "," + this.year.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                type == book.type;
    }
}
