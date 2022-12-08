package use_cases.delete_friend.interface_adapter;

public class DeleteFriendFailure extends RuntimeException {
    public DeleteFriendFailure(String errorMessage) {
        super(errorMessage);
    }
}
