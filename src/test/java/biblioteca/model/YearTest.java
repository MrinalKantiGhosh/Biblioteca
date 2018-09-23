package biblioteca.model;

import biblioteca.model.valueObjects.Year;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearTest {
    @DisplayName("expect 2010 as Year of publish")
    @Test
    void testOfGetYearOfPublish(){
        Year year = new Year(2010);
        assertEquals(2010, year.getValue());
    }

    @DisplayName("return true for two same year object")
    @Test
    void returnTrueForTwoSameYearObject(){
        Year year1 = new Year(2010);
        Year year2 = new Year(2010);
        assertEquals(year1, year2);
    }

    @DisplayName("return not true for two different year object")
    @Test
    void returnTrueForTwoDifferentYearObject(){
        Year year1 = new Year(2010);
        Year year2 = new Year(2012);
        assertNotEquals(year1, year2);
    }

}