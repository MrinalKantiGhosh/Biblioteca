package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ListBook implements Command{
    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.printListOfBooks(library.getBookDetails());
    }
}
