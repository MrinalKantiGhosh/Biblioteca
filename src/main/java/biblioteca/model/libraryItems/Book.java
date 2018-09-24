package biblioteca.model.libraryItems;

import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.Year;

import java.util.Objects;

public class Book implements LibraryItem {
    private final Name name;
    private final Person author;
    private final Year year;
    ItemType type;


    public Book(Name name, Person author, Year year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.type = ItemType.BOOK;
    }

    public Book(Name name){
        this(name, new Person(""), new Year(0));
    }

    @Override
    public ItemType getItemType() {
        return this.type;
    }

    @Override
    public String getItemDetail() {
        return this.name.getValue() + "," + this.author.getValue() + "," + this.year.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                type == book.type;
    }
}
