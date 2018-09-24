package biblioteca.model;

import biblioteca.model.libraryItems.Movie;
import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Rating;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    Name name1;
    Name name2;
    Person person1;
    Person person2;
    Year year1;
    Year year2;
    Movie movie1;
    Movie movie2;

    @BeforeEach
    void init(){
        name1 = new Name("movie1");
        name2 = new Name("movie2");
        person1 = new Person("person1");
        person2 = new Person("person2");
        year1 = new Year(2010);
        year2 = new Year(2012);
        movie1 = new Movie(name1, person1, year1, new Rating(0));
        movie2 = new Movie(name2, person2, year2, new Rating(0));
    }

    @DisplayName("should return true for two same movie object")
    @Test
    void returnTrueForSameMovieObject(){
        Movie newMovie = new Movie(name1, person1, year1, new Rating(0));
        assertEquals(newMovie, movie1);
    }

    @DisplayName("should not return true for two different movie object")
    @Test
    void returnFalseForDifferentMovieObject(){
        assertNotEquals(movie2, movie1);
    }

}