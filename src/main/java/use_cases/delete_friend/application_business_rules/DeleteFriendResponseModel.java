package use_cases.delete_friend.application_business_rules;

public class DeleteFriendResponseModel {
    private final String friendToDelete;
    private String message;
    public DeleteFriendResponseModel(String friendToDelete, String message) {
        this.friendToDelete = friendToDelete;
        this.message = message;
    }

    public String getFriendToDelete() {
        return friendToDelete;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage) {
        this.message = newMessage;
    }
}
