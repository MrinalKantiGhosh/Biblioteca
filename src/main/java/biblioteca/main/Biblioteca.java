package biblioteca.main;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import biblioteca.model.*;

import java.util.Collection;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        List<Book> books = new BookRepository().getBooks();
        Library library = new Library(books);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver, library, inputDriver);
        libraryManagementSystem.start();
    }
}
