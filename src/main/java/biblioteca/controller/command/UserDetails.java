package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class UserDetails implements Command{
    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        outputDriver.printUserDetails(authorizedUsers.fetchLoggedInUser().getUserDetails());
    }
}
