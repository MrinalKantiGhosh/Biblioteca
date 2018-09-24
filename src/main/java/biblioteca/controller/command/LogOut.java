package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class LogOut implements Command {
    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        if(authorizedUsers.isLoggedIn()){
            authorizedUsers.logout();
            outputDriver.println(Messages.SUCCESSFUL_LOG_OUT);
        }else{
            outputDriver.println(Messages.NOT_LOGGED_IN_YET);
        }
    }
}
