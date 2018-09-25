package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.model.valueObjects.Password;
import biblioteca.model.valueObjects.UserId;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Messages.*;

public class LogInCommand implements Command {
    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        if (!authorizedUsers.isLoggedIn()) {
            outputDriver.print(ASK_FOR_USER_ID);
            String userId = inputDriver.getInputString();
            outputDriver.print(ASK_FOR_PASSWORD);
            String password = inputDriver.getInputString();
            User currentUser = new User(new UserId(userId), new Password(password));

            if (authorizedUsers.isValidUser(currentUser)) {
                authorizedUsers.logIn(currentUser);
                outputDriver.println(SUCCESSFUL_LOG_IN);
            } else {
                outputDriver.println(NOT_A_VALID_USER);
            }
        } else {
            outputDriver.println(ALREADY_LOGGED_IN);
        }
    }
}