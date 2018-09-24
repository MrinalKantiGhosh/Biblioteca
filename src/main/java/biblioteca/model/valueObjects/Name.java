package biblioteca.model.valueObjects;

import java.util.Objects;

public class Name {
    private final String title;

    public Name(String title) {
        this.title = title;
    }

    public String getValue(){
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(title, name1.title);
    }
}
