package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class Quit implements Command {
    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.println(Messages.EXIT_MESSAGE);
    }
}
