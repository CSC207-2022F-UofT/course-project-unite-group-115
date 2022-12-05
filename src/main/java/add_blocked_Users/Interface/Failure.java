package add_blocked_Users.Interface;

public class Failure extends RuntimeException {
    public Failure(String errorMessage) {
        super(errorMessage);
    }
}
