package biblioteca.controller;


import biblioteca.controller.command.*;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {
    QUIT("Quit", new Quit()) {
    },
    LIST_BOOKS("List Books", new ListItem(ItemType.BOOK)) {
    },
    CHECKOUT_BOOK("Checkout Book", new AuthorizedCommand(new CheckoutItem(ItemType.BOOK))) {
    },
    RETURN_BOOK("Return Book", new ReturnItem(ItemType.BOOK)){
    },
    LIST_MOVIE("List Movie", new ListItem(ItemType.MOVIE)) {
    },
    CHECKOUT_MOVIE("Checkout Movie", new AuthorizedCommand(new CheckoutItem(ItemType.MOVIE))) {
    },
    RETURN_MOVIE("Return Movie", new AuthorizedCommand(new ReturnItem(ItemType.MOVIE))){
    },
    LOGIN("Log In", new LogIn()){
    },
    LOGOUT("Log Out", new LogOut()){
    },
    USERDETAILS("User Details", new AuthorizedCommand(new UserDetails()));

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