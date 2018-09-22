package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books;
    List<Book> checkoutListOfBooks;

    public Library(List<Book> books) {
        this.books = books;
        checkoutListOfBooks = new ArrayList<>();
    }

    public List<String> getBookDetails(){
        ArrayList<String> bookDetails = new ArrayList<>();

        for(Book book : books){
            String individualBookDetail = book.getTitle().getValue()
                    + "\t\t" + book.getAuthor().getValue() + "\t\t"
                    + book.getYear().getValue();
            bookDetails.add(individualBookDetail);
        }

        return bookDetails;
    }

    public void checkoutBook(Book selectedBook){
         int indexOfBook = books.indexOf(selectedBook);
         checkoutListOfBooks.add(books.remove(indexOfBook));
    }

    public void returnBook(Book selectedBookForReturn){
        int indexOfBook = checkoutListOfBooks.indexOf(selectedBookForReturn);
        books.add(checkoutListOfBooks.remove(indexOfBook));
    }

    public boolean isContains(Book book){
        return books.contains(book);
    }

    public boolean hasChecked(Book book){
        return checkoutListOfBooks.contains(book);
    }
}
