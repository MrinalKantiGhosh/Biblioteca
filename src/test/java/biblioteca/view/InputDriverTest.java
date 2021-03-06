package biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {
    @DisplayName("Test input for select menu option")
    @Test
    void testInputForSelectOptionForMenu(){
        setSystem("3\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(3, inputDriver.getInputInteger());
    }

    @DisplayName("Test input for getting book name to checkout")
    @Test
    void testInputForBookNameToCheckout(){
        setSystem("Book1");

        InputDriver inputDriver = new InputDriver();
        assertEquals("Book1", inputDriver.getInputString());
    }

    private void setSystem(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setup(){
        System.setIn(System.in);
    }

}