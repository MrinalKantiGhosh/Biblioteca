package biblioteca.model.valueObjects;

public class Rating {
    private final int rating;

    public Rating(int rating) {
        this.rating = rating;
    }

    public int getValue(){
        return rating;
    }
}
