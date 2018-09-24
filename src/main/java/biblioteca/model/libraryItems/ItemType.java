package biblioteca.model.libraryItems;

import biblioteca.model.valueObjects.Name;

public enum ItemType {
    BOOK{
        @Override
        public LibraryItem createItemForTitle(String title) {
            return new Book(new Name(title));
        }
    },
    MOVIE {
        @Override
        public LibraryItem createItemForTitle(String title) {
            return new Movie(new Name(title));
        }
    };

    public abstract LibraryItem createItemForTitle(String title);
}
