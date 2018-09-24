package biblioteca.model;

import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.valueObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final UserId userId;
    private final Password password;
    private final Name name;
    private final Email email;
    private final PhoneNumber phoneNumber;
    private final List<LibraryItem> checkoutList;

    public User(UserId userId, Password password, Name name, Email email, PhoneNumber phoneNumber) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkoutList = new ArrayList<>();
    }

    public User(UserId userId, Password password) {
        this(userId, password, new Name(""), new Email(""), new PhoneNumber(""));
    }

    public String getUserDetails(){
        return this.name.getValue() + "," + this.email.getValue() + "," + this.phoneNumber.getValue();
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
