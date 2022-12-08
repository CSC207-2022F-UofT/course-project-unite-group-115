package use_cases.add_blocked_users.Interface_adapters;

public class AddBlockedUserFailure extends RuntimeException {
    public AddBlockedUserFailure(String errorMessage) {
        super(errorMessage);
    }
}
