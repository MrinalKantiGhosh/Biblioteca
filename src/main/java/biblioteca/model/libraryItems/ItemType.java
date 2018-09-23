package biblioteca.model.libraryItems;

import biblioteca.model.libraryItems.Book;
import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.libraryItems.Movie;
import biblioteca.model.valueObjects.Title;

public enum ItemType {
    BOOK{
        @Override
        public LibraryItem createItemForTitle(String title) {
            return new Book(new Title(title));
        }
    },
    MOVIE {
        @Override
        public LibraryItem createItemForTitle(String title) {
            return new Movie(new Title(title));
        }
    };

    public abstract LibraryItem createItemForTitle(String title);
}
