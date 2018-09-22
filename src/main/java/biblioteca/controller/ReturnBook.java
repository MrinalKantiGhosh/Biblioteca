package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnBook implements Command{

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Messages.ASK_FOR_BOOK_NAME_TO_RETURN);
        String bookName = inputDriver.getInputBookName();
        Book selectedBookForReturn = new Book(new Title(bookName));

        if(library.hasChecked(selectedBookForReturn)){
            library.returnBook(selectedBookForReturn);
            outputDriver.print(Messages.SUCCESSFULL_RETURN_MESSAGE);
        }else{
            outputDriver.print(Messages.UNSUCCESSFULL_RETURN_MESSAGE);
        }
    }
}
