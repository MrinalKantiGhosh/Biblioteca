package biblioteca.model.valueObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {
    @DisplayName("check whether return right value for an object ")
    @Test
    void checkGetValue(){
        PhoneNumber phoneNumber = new PhoneNumber("mrinalghosh2196@gmail.com");
        assertEquals("mrinalghosh2196@gmail.com", phoneNumber.getValue());
    }

    @DisplayName("return true for two phoneNumber object having same value")
    @Test
    void returnTrueForEqualPhoneNumberObjects(){
        PhoneNumber phoneNumber1 = new PhoneNumber("phoneNumber");
        PhoneNumber phoneNumber2 = new PhoneNumber("phoneNumber");
        assertEquals(phoneNumber1, phoneNumber2);
    }

    @DisplayName("return same for two phoneNumber object having different value")
    @Test
    void returnFalseForDifferentPhoneNumberObjects(){
        PhoneNumber phoneNumber1 = new PhoneNumber("phoneNumber1");
        PhoneNumber phoneNumber2 = new PhoneNumber("phoneNumber2");
        assertNotEquals(phoneNumber1, phoneNumber2);
    }
}