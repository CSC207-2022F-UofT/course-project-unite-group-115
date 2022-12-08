package use_cases.get_friends.use_case;
import entities.Profile;

public class GetFriendsDsRequestModel {
    private String username;

    /**
     * Creates data structure that is required to find the friends of the user
     * @param username the profile of the user
     */
    public GetFriendsDsRequestModel(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

}
