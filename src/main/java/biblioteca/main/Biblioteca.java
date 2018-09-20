package biblioteca.main;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.view.OutputDriver;
import biblioteca.model.*;

import java.util.Collection;

public class Biblioteca {
    public static void main(String[] args) {
        OutputDriver outputDriver = new OutputDriver();
        Collection<Book> bookList = new GetBookList().getBookList();
        Library library = new Library(bookList);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library);
        libraryManagementSystem.start();

    }
}
