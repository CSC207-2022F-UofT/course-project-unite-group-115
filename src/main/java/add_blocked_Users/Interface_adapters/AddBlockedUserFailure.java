package add_blocked_Users.Interface_adapters;

public class AddBlockedUserFailure extends RuntimeException {
    public AddBlockedUserFailure(String errorMessage) {
        super(errorMessage);
    }
}
