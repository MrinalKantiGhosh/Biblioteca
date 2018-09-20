package biblioteca.model;

import java.util.Objects;

public class Title {
    private final String title;

    public Title(String title) {
        this.title = title;
    }

    public String getValue(){
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }
}
