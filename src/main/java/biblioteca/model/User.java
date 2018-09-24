package biblioteca.model;

import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.valueObjects.Password;
import biblioteca.model.valueObjects.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final UserId userId;
    private final Password password;
    private final List<LibraryItem> checkoutList;

    public User(UserId userId, Password password) {
        this.userId = userId;
        this.password = password;
        this.checkoutList = new ArrayList<>();
    }

    public void checkoutItem(LibraryItem item) {
        checkoutList.add(item);
    }

    public LibraryItem returnItem(LibraryItem item) {
        int indexOfItem = checkoutList.indexOf(item);
        return checkoutList.remove(indexOfItem);
    }

    public boolean contains(LibraryItem item) {
        return checkoutList.contains(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(password, user.password);
    }

}
