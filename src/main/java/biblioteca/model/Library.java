package biblioteca.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {
    List<Book> books;
    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Title> getTitleFromListOfBooks() {
        List<Title> titleList = new ArrayList<>();
        for (Book book : books) {
            titleList.add(book.getTitle());
        }
        return titleList;
    }

    public List<Author> getAuthorFromListOfBooks() {
        List<Author> authorList = new ArrayList<>();
        for (Book book : books) {
            authorList.add(book.getAuthor());
        }
        return authorList;
    }

    public List<Year> getYearOfPublishFromListOfBooks() {
        List<Year> yearList = new ArrayList<>();
        for (Book book : books) {
            yearList.add(book.getYear());
        }
        return yearList;
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
         books.remove(selectedBook);
    }

    public boolean isContains(Book book){
        return books.contains(book);
    }
}
