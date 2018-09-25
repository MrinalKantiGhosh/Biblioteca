package biblioteca.main;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.repository.BookRepository;
import biblioteca.model.repository.MovieRepository;
import biblioteca.model.repository.UserRepository;
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
        AuthorizedUsers authorizedUsers = new AuthorizedUsers(new UserRepository().getUsers());

        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(library, outputDriver, inputDriver, authorizedUsers);
        libraryManagementSystem.start();
    }
}