package add_friend.application_business_rules;

public class AddFriendResponseModel {
    private final String newFriend;
    private String message;

    public AddFriendResponseModel(String newFriend, String message) {
        this.newFriend = newFriend;
        this.message = message;
    }

    public String getNewFriend() {
        return newFriend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage){
        this.message = newMessage;
    }
}
