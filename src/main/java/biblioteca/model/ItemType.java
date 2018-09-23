package biblioteca.model;

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
