package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    Title title1;
    Title title2;
    Person person1;
    Person person2;
    Year year1;
    Year year2;
    Movie movie1;
    Movie movie2;

    @BeforeEach
    void init(){
        title1 = new Title("movie1");
        title2 = new Title("movie2");
        person1 = new Person("person1");
        person2 = new Person("person2");
        year1 = new Year(2010);
        year2 = new Year(2012);
        movie1 = new Movie(title1, person1, year1, new Rating(0));
        movie2 = new Movie(title2, person2, year2, new Rating(0));
    }

    @DisplayName("should return true for two same movie object")
    @Test
    void returnTrueForSameMovieObject(){
        Movie newMovie = new Movie(title1, person1, year1, new Rating(0));
        assertEquals(newMovie, movie1);
    }

    @DisplayName("should not return true for two different movie object")
    @Test
    void returnFalseForDifferentMovieObject(){
        assertNotEquals(movie2, movie1);
    }

}