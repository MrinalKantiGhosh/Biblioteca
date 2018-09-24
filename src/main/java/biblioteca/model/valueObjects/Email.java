package biblioteca.model.valueObjects;

import java.util.Objects;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public String getValue(){
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }
}
