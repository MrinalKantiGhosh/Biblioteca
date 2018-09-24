package biblioteca.model.repository;

import biblioteca.model.User;
import biblioteca.model.valueObjects.*;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    User user1;
    User user2;
    User user3;
    User user4;

    public UserRepository() {
        this.user1 = new User(new UserId("abc-1234"), new Password("abc"), new Name("user1"), new Email("abc@gmail.com"), new PhoneNumber("1234567890"));
        this.user2 = new User(new UserId("def-5678"), new Password("def"), new Name("user2"), new Email("def@gmail.com"), new PhoneNumber("1234567890"));
        this.user3 = new User(new UserId("ghi-9012"), new Password("ghi"), new Name("user3"), new Email("ghi@gmail.com"), new PhoneNumber("1234567890"));
        this.user4 = new User(new UserId("jkl-3456"), new Password("jkl"), new Name("user4"), new Email("jkl@gmail.com"), new PhoneNumber("1234567890"));
    }

    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return users;
    }
}
