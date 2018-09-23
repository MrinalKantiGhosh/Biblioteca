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
    private final List<LibraryItem> checkList;

    public User(UserId userId, Password password) {
        this.userId = userId;
        this.password = password;
        this.checkList = new ArrayList<>();
    }

    public void checkoutItem(LibraryItem item) {
        checkList.add(item);
    }

    public boolean returnItem(LibraryItem item) {
        return checkList.remove(item);
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
