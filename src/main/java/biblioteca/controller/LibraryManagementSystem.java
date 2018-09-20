package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Author;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.model.Year;
import biblioteca.view.OutputDriver;

import java.util.List;


public class LibraryManagementSystem {
    OutputDriver outputDriver;
    Library library;

    public LibraryManagementSystem(OutputDriver outputDriver, Library library){
        this.outputDriver = outputDriver;
        this.library = library;
    }

    private void welcomeMessage(){
        outputDriver.print(Messages.WELCOME_MESSAGE);
    }

    private void showBookDetails(){
        List<Title> titleList = library.getTitleFromListOfBooks();
        List<Author> authorList = library.getAuthorFromListOfBooks();
        List<Year> yearList = library.getYearOfPublishFromListOfBooks();

        for(int itr = 0; itr < titleList.size(); itr++){
            outputDriver.print(
                    titleList.get(itr).getValue()
                    + "\t\t" + authorList.get(itr).getValue()
                    + "\t\t" + yearList.get(itr).getValue());
        }
    }

    public void start(){
        welcomeMessage();
        showBookDetails();
    }

}
