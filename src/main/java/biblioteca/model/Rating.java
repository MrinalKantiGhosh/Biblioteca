package biblioteca.model;

public class Rating {
    private final int rating;

    public Rating(int rating) {
        this.rating = rating;
    }

    int getValue(){
        return rating;
    }
}
