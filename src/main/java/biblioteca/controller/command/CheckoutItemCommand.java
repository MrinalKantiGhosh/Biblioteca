package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckoutItemCommand implements Command {
    private ItemType type;

    public CheckoutItemCommand(ItemType type) {
        this.type = type;
    }

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver, AuthorizedUsers authorizedUsers) {
        outputDriver.print(Messages.ASK_FOR_ITEM_NAME_TO_CHECKOUT);
        String title = inputDriver.getInputString();
        outputDriver.println(library.checkoutItem(title, authorizedUsers.fetchLoggedInUser() , type));
    }
}
