package biblioteca.main;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import biblioteca.model.*;

import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        List<LibraryItem> items = new BookRepository().getBooks();
        items.addAll(new MovieRepository().getMovies());
        Library library = new Library(items);

        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(library, outputDriver, inputDriver);
        libraryManagementSystem.start();
    }
}
