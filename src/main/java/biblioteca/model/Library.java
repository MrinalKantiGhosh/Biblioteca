package biblioteca.model;

import biblioteca.common.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Library {
    List<LibraryItem> items;
    List<LibraryItem> checkoutListOfItems;

    public Library(List<LibraryItem> items) {
        this.items = items;
        checkoutListOfItems = new ArrayList<>();
    }

    public List<String> getLibraryItemDetails(ItemType type) {
        return items.stream()
                .filter(libraryItem -> libraryItem.getItemType() == type)
                .map(LibraryItem::getItemDetail)
                .collect(Collectors.toList());
    }

    private boolean isContains(LibraryItem item) {
        return items.contains(item);
    }

    public boolean hasChecked(LibraryItem item) {
        return checkoutListOfItems.contains(item);
    }

    public String checkoutItem(String title, ItemType type) {
        LibraryItem selectedItemForCheckout = type.createItemForTitle(title);

        if (!isContains(selectedItemForCheckout)) {
            return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }
        int indexOfItem = items.indexOf(selectedItemForCheckout);
        checkoutListOfItems.add(items.remove(indexOfItem));
        return Messages.SUCCESSFUL_CHECKOUT_MESSAGE;

    }

    public String returnItem(String title, ItemType type){
        LibraryItem selectedItemForReturn = type.createItemForTitle(title);

        if(!hasChecked(selectedItemForReturn)){
            return Messages.UNSUCCESSFUL_RETURN_MESSAGE;
        }
        int indexOfItem = checkoutListOfItems.indexOf(selectedItemForReturn);
        items.add(checkoutListOfItems.remove(indexOfItem));
        return Messages.SUCCESSFUL_RETURN_MESSAGE;
    }
}
