package biblioteca.model.libraryItems;

import biblioteca.model.valueObjects.Person;
import biblioteca.model.valueObjects.Rating;
import biblioteca.model.valueObjects.Title;
import biblioteca.model.valueObjects.Year;

import java.util.Objects;

public class Movie implements LibraryItem {
    private final Title title;
    private final Person director;
    private final Year year;
    private final Rating rating;
    final ItemType type;


    public Movie(Title title, Person director, Year year, Rating rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.type = ItemType.MOVIE;
    }

    public Movie(Title title){
        this(title, new Person(""), new Year(0), new Rating(0));
    }

    private String fetchRating(){
        if(rating.getValue() == 0) {
            return  "Unrated";
        }else{
            return String.valueOf(rating.getValue());
        }
    }

    @Override
    public ItemType getItemType() {
        return this.type;
    }

    @Override
    public String getItemDetail() {
        return this.title.getValue() + "," + this.director.getValue() + "," + this.year.getValue() + "," + fetchRating();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                type == movie.type;
    }
}
