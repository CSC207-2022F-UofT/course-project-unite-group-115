package use_cases.delete_friend.application_business_rules;

public class DeleteFriendRequestModel {
    private String loggedInUser;
    private String friendUsername;

    public DeleteFriendRequestModel(String loggedInUser, String friendUsername){
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
