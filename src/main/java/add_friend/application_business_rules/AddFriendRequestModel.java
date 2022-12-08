package add_friend.application_business_rules;

public class AddFriendRequestModel {
    private String loggedInUser;
    private String friendUsername;

    public AddFriendRequestModel(String loggedInUser, String friendUsername){
        this.loggedInUser = loggedInUser;
        this.friendUsername = friendUsername;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }
}
