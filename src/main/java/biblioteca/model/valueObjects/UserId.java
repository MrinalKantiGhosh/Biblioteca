package biblioteca.model.valueObjects;

import java.util.Objects;

public class UserId {
    private final String userId;
    private static final int LENGTH_OF_VALID_USER_ID = 8;
    private static final int DIFFERENTIATOR_POSITION = 3;
    private static final String DIFFERENTIATOR = "-";

    public UserId(String userId) {
        this.userId = userId;
    }

    public boolean checkValidFormat(){
        if(userId.length() == LENGTH_OF_VALID_USER_ID && userId.indexOf(DIFFERENTIATOR) == DIFFERENTIATOR_POSITION){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId1 = (UserId) o;
        return Objects.equals(userId, userId1.userId);
    }
}
