package biblioteca.model.valueObjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserIdTest {
    @DisplayName("return true for valid formatted user id")
    @Test
    void returnTrueForValidFormattedUserid(){
        UserId userId = new UserId("344-124x");
        assertTrue(userId.checkValidFormat());
    }

    @DisplayName("return false for un-valid formatted user id")
    @Test
    void returnFalseForUnvalidFormattedUserid(){
        UserId userId = new UserId("3s44-124x");
        assertFalse(userId.checkValidFormat());
    }

    @DisplayName("return false for un-valid formatted user id when differentiator is in wrong place")
    @Test
    void returnFalseForUnvalidFormattedUseridHavingDifferentiatorInWrongPlace(){
        UserId userId = new UserId("3s441-24x");
        assertFalse(userId.checkValidFormat());
    }
}