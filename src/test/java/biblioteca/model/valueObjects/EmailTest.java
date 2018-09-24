package biblioteca.model.valueObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmailTest {
    @DisplayName("check whether return right value for an object ")
    @Test
    void checkGetValue(){
        Email email = new Email("mrinalghosh2196@gmail.com");
        assertEquals("mrinalghosh2196@gmail.com", email.getValue());
    }

    @DisplayName("return true for two email object having same value")
    @Test
    void returnTrueForEqualEmailObjects(){
        Email email1 = new Email("email");
        Email email2 = new Email("email");
        assertEquals(email1, email2);
    }

    @DisplayName("return same for two email object having different value")
    @Test
    void returnFalseForDifferentEmailObjects(){
        Email email1 = new Email("email1");
        Email email2 = new Email("email2");
        assertNotEquals(email1, email2);
    }
}