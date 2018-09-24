package biblioteca.model.repository;

import biblioteca.model.libraryItems.LibraryItem;
import biblioteca.model.libraryItems.Movie;
import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Rating;
import biblioteca.model.valueObjects.Name;
import biblioteca.model.valueObjects.Year;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    Movie Movie1;
    Movie Movie2;
    Movie Movie3;
    Movie Movie4;

    public MovieRepository(){
        Movie1 = new Movie(new Name("movie1"), new Person("director1"), new Year(2010), new Rating(0));
        Movie2 = new Movie(new Name("movie2"), new Person("director2"), new Year(2011), new Rating(10));
        Movie3 = new Movie(new Name("movie3"), new Person("director3"), new Year(2012), new Rating(3));
        Movie4 = new Movie(new Name("movie4"), new Person("director4"), new Year(2013), new Rating(9));
    }

    public List<LibraryItem> getMovies(){
        ArrayList<LibraryItem> movies = new ArrayList<>();
        movies.add(Movie1);
        movies.add(Movie2);
        movies.add(Movie3);
        movies.add(Movie4);

        return movies;
    }
}
