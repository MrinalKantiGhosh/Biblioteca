package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnItem implements Command {
    private final ItemType type;

    public ReturnItem(ItemType type) {
        this.type = type;
    }

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        outputDriver.print(Messages.ASK_FOR_ITEM_NAME_TO_RETURN);
        String title = inputDriver.getInputString();

        outputDriver.println(library.returnItem(title, type));
    }
}
