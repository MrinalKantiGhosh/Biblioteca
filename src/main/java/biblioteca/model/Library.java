package biblioteca.model;

import biblioteca.common.Messages;
import biblioteca.model.libraryItems.ItemType;
import biblioteca.model.libraryItems.LibraryItem;

import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryItem> items;

    public Library(List<LibraryItem> items) {
        this.items = items;
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

    private boolean hasChecked(LibraryItem item, User user) {
        return user.contains(item);
    }

    public String checkoutItem(String title, User user, ItemType type) {
        LibraryItem selectedItemForCheckout = type.createItemForTitle(title);

        if (!isContains(selectedItemForCheckout)) {
            return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }
        int indexOfItem = items.indexOf(selectedItemForCheckout);
        user.checkoutItem(items.remove(indexOfItem));
        return Messages.SUCCESSFUL_CHECKOUT_MESSAGE;

    }

    public String returnItem(String title, User user, ItemType type){
        LibraryItem selectedItemForReturn = type.createItemForTitle(title);

        if(!hasChecked(selectedItemForReturn, user)){
            return Messages.UNSUCCESSFUL_RETURN_MESSAGE;
        }
        items.add(user.returnItem(selectedItemForReturn));
        return Messages.SUCCESSFUL_RETURN_MESSAGE;
    }
}
