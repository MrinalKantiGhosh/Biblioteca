package biblioteca.controller;


import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {
    QUIT("Quit", new Quit()) {
    },
    LIST_BOOKS("List Books", new ListBook()) {
    },
    CHECKOUT("Checkout", new CheckoutBook()) {
    },
    RETURN("Return Book", new ReturnBook()){
    };

    void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver){
        this.command.performCommand(library, outputDriver, inputDriver);
    }

    private final String message;
    private final Command command;

    Menu(String message, Command command) {
        this.message = "Enter " + ordinal() + " to " + message;
        this.command = command;
    }

    public String getMessage() {
        return message;
    }
}