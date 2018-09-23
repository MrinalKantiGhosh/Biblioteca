package biblioteca.model.valueObjects;

import java.util.Objects;

public class Person {
    private final String authorName;

    public Person(String authorName) {
        this.authorName = authorName;
    }

    public String getValue(){
        return authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(authorName, person.authorName);
    }
}
