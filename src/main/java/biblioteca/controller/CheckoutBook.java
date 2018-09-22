package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckoutBook implements Command{

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Messages.ASK_FOR_BOOK_NAME_TO_CHECKOUT);
        String bookName = inputDriver.getInputBookName();
        Book selectedBook = new Book(new Title(bookName));

        if (library.isContains(selectedBook)) {
            library.checkoutBook(selectedBook);
            outputDriver.print(Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
        }else {
            outputDriver.print(Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }

    }
}
