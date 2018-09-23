package biblioteca.model;

import biblioteca.model.valueObjects.Rating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    @DisplayName("get Rating value for 9")
    @Test
    void testGetValueForRatingFor9(){
        assertEquals(9, new Rating(9).getValue());
    }
}