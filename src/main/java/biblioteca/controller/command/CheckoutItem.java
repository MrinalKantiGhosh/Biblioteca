package biblioteca.controller.command;

import biblioteca.common.Messages;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckoutItem implements Command {
    ItemType type;

    public CheckoutItem(ItemType type) {
        this.type = type;
    }

    @Override
    public void performCommand(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Messages.ASK_FOR_ITEM_NAME_TO_CHECKOUT);
        String title = inputDriver.getInputItemName();
        outputDriver.println(library.checkoutItem(title, type));
    }
}
