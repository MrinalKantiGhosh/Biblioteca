package biblioteca.controller.command;

import biblioteca.model.AuthorizedUsers;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ListItemCommand implements Command {
    private final ItemType type;

    public ListItemCommand(ItemType type) {
        this.type = type;
    }

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        outputDriver.printListOfItems(library.getLibraryItemDetails(type));
    }
}
