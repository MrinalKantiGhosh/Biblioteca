package biblioteca.model.valueObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @DisplayName("return true for two password object having same value")
    @Test
    void returnTrueForSamePassword(){
        assertEquals(new Password("qwerty"), new Password("qwerty"));
    }
    @DisplayName("return false for two password object having different value")
    @Test
    void returnFalseForDifferentPassword(){
        assertNotEquals(new Password("qwerty"), new Password("password"));
    }

}