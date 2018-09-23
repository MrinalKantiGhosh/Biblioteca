package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @DisplayName("expect PersonTest as author")
    @Test
    void testForGetAuthor(){
        Person person = new Person("PersonTest");
        assertEquals("PersonTest", person.getValue());
    }

    @DisplayName("return true for two same author object")
    @Test
    void returnTrueForTwoSameAuthorObject(){
        Person person1 = new Person("Author1");
        Person person2 = new Person("Author1");
        assertEquals(person1, person2);
    }

    @DisplayName("return not true for two different author object")
    @Test
    void returnTrueForTwoDifferentAuthorObject(){
        Person person1 = new Person("Author1");
        Person person2 = new Person("Author2");
        assertNotEquals(person1, person2);
    }
}
