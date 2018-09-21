package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.Title;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {
    QUIT("Quit") {
        @Override
        public void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver) {

        }
    },
    LIST_BOOKS("List Books") {
        @Override
        public void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.printListOfBooks(library.getBookDetails());
        }
    },
    CHECKOUT("Checkout") {
        @Override
        public void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
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
    },
    RETURN("Return Book"){
        @Override
        public void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
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
    };

    public abstract void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver);

    private final String message;

    Menu(String message) {
        this.message = "Enter " + ordinal() + " to " + message;
    }

    public String getMessage() {
        return message;
    }
}
