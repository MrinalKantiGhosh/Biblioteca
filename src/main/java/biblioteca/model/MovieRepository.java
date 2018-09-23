package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    Movie Movie1;
    Movie Movie2;
    Movie Movie3;
    Movie Movie4;

    public MovieRepository(){
        Movie1 = new Movie(new Title("movie1"), new Person("director1"), new Year(2010), new Rating(0));
        Movie2 = new Movie(new Title("movie2"), new Person("director2"), new Year(2011), new Rating(10));
        Movie3 = new Movie(new Title("movie3"), new Person("director3"), new Year(2012), new Rating(3));
        Movie4 = new Movie(new Title("movie4"), new Person("director4"), new Year(2013), new Rating(9));
    }

    public List<LibraryItem> getMovies(){
        ArrayList<LibraryItem> Movies = new ArrayList<>();
        Movies.add(Movie1);
        Movies.add(Movie2);
        Movies.add(Movie3);
        Movies.add(Movie4);

        return Movies;
    }
}
