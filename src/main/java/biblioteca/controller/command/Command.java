package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public interface Command{
    void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers);
}