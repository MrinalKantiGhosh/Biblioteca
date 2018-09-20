package biblioteca.model;

public class Year {
    private final int yearOfPublish;

    public Year(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getValue(){
        return yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year that = (Year) o;
        return yearOfPublish == that.yearOfPublish;
    }
}
