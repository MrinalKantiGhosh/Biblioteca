package biblioteca.resources;

import biblioteca.common.Messages;
import biblioteca.common.OutputDriver;
import java.util.Collection;

public class LibraryManagementSystem {
    OutputDriver outputDriver;
    Collection<Book> books;

    LibraryManagementSystem(OutputDriver outputDriver, Collection<Book> books){
        this.outputDriver = outputDriver;
        this.books = books;
        welcomeMessage();
        showListOfBooks();
    }

    private void welcomeMessage(){
        outputDriver.print(Messages.WELCOME_MESSAGE);
    }

    private void showListOfBooks(){
        for(Book book : books){
            outputDriver.print(book.toString());
        }
    }


}
