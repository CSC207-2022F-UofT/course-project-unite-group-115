package add_friend.interface_adapter;

public class AddFriendFailure extends RuntimeException {
    public AddFriendFailure(String errorMessage) {
        super(errorMessage);
    }
}
