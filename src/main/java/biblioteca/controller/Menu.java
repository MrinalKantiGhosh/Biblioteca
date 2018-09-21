package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.OutputDriver;

public enum Menu {
    QUIT("Quit") {
        @Override
        public void performAction(Library library, OutputDriver outputDriver) {

        }
    },
    LIST_BOOKS("List Books") {
        @Override
        public void performAction(Library library, OutputDriver outputDriver) {
            outputDriver.printListOfBooks(library.getBookDetails());
        }
    };

    public abstract void performAction(Library library, OutputDriver outputDriver);

    private final String message;
    Menu(String message) {
        this.message = "Enter " + ordinal() + " to " + message;
    }

    public String getMessage(){
        return message;
    }
}
