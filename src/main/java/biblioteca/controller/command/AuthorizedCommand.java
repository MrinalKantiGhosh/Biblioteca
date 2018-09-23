package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class AuthorizedCommand implements Command {
    private Command command;

    public AuthorizedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        if(authorizedUsers.isLoggedIn()){
            this.command.performCommand(library, outputDriver, inputDriver, authorizedUsers);
        }else{
            outputDriver.println(Messages.NOT_LOGGED_IN_YET);
        }
    }
}
