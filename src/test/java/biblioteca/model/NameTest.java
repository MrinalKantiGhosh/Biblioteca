package biblioteca.model;

import biblioteca.model.valueObjects.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @DisplayName("expect BookTest as title of book1")
    @Test
    void testGetTitle(){
        Name name = new Name("BookTest");

        assertEquals("BookTest", name.getValue());
    }

    @DisplayName("return true for two same title object")
    @Test
    void returnTrueForTwoSameTitleObject(){
        Name name1 = new Name("Book1");
        Name name2 = new Name("Book1");

        assertEquals(name1, name2);
    }

    @DisplayName("return not true for two different title object")
    @Test
    void returnTrueForTwoDifferentTitleObject(){
        Name name1 = new Name("Book1");
        Name name2 = new Name("Book2");

        assertNotEquals(name1, name2);
    }
}