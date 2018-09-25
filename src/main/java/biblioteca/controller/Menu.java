package biblioteca.controller;


import biblioteca.controller.command.*;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {
    QUIT("QuitCommand", new QuitCommand()) {
    },
    LIST_BOOKS("List Books", new ListItemCommand(ItemType.BOOK)) {
    },
    CHECKOUT_BOOK("Checkout Book", new AuthorizedCommand(new CheckoutItemCommand(ItemType.BOOK))) {
    },
    RETURN_BOOK("Return Book", new AuthorizedCommand(new ReturnItemCommand(ItemType.BOOK))){
    },
    LIST_MOVIE("List Movie", new ListItemCommand(ItemType.MOVIE)) {
    },
    CHECKOUT_MOVIE("Checkout Movie", new AuthorizedCommand(new CheckoutItemCommand(ItemType.MOVIE))) {
    },
    RETURN_MOVIE("Return Movie", new AuthorizedCommand(new ReturnItemCommand(ItemType.MOVIE))){
    },
    LOGIN("Log In", new LogInCommand()){
    },
    LOGOUT("Log Out", new LogOutCommand()){
    },
    USERDETAILS("User Details", new AuthorizedCommand(new UserDetailsCommand()));

    void performAction(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers){
        this.command.performCommand(library, outputDriver, inputDriver, authorizedUsers);
    }

    private final String message;
    private final Command command;

    Menu(String message, Command command) {
        this.message = "Enter " + ordinal() + " to " + message;
        this.command = command;
    }

    String getMessage() {
        return message;
    }
}