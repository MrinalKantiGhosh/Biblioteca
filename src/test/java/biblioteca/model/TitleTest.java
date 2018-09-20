package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleTest {
    @DisplayName("expect BookTest as title of book")
    @Test
    void testGetTitle(){
        Title title = new Title("BookTest");

        assertEquals("BookTest", title.getValue());
    }

    @DisplayName("return true for two same title object")
    @Test
    void returnTrueForTwoSameTitleObject(){
        Title title1 = new Title("Book1");
        Title title2 = new Title("Book1");

        assertEquals(title1, title2);
    }

    @DisplayName("return not true for two different title object")
    @Test
    void returnTrueForTwoDifferentTitleObject(){
        Title title1 = new Title("Book1");
        Title title2 = new Title("Book2");

        assertNotEquals(title1, title2);
    }
}