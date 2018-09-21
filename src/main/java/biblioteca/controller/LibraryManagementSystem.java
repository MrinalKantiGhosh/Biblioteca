package biblioteca.controller;

import biblioteca.common.Messages;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;


public class LibraryManagementSystem {
    private final OutputDriver outputDriver;
    private final Library library;
    private final InputDriver inputDriver;

    public LibraryManagementSystem(OutputDriver outputDriver, Library library, InputDriver inputDriver) {
        this.outputDriver = outputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
    }

    private void welcomeMessage() {
        outputDriver.print(Messages.WELCOME_MESSAGE);
    }

    public void start() {
        welcomeMessage();
        menuOptions();
    }

    private boolean isValidInput(int input) {
        return input >= 0 && input < Menu.values().length;
    }

    private void menuOptions() {
        int getInputFromUser;
        do {
            printMenu();
            getInputFromUser = inputDriver.getInputFromUserForSelectMenuOption();
            if (isValidInput(getInputFromUser)) {
                Menu.values()[getInputFromUser].performAction(library, outputDriver, inputDriver);
            } else {
                outputDriver.print(Messages.ASK_FOR_VALID_INPUT);
            }
        } while (getInputFromUser != Menu.QUIT.ordinal());
    }

    private void printMenu() {
        for(int itr = 0; itr < Menu.values().length; itr++){
            outputDriver.print(Menu.values()[itr].getMessage());
        }
        outputDriver.print(Messages.ASK_FOR_INPUT_FROM_THE_USER);
    }

}
