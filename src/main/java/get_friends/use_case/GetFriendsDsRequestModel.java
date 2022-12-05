package get_friends.use_case;
import get_friends.entities.Profile;

public class GetFriendsDsRequestModel {
    private Profile userProfile;

    /**
     * Creates data structure that is required to find the friends of the user
     * @param userProfile the profile of the user
     */
    public GetFriendsDsRequestModel(Profile userProfile) {
        this.userProfile = userProfile;
    }

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }

    public Profile getUserProfile() {
        return this.userProfile;
    }

}
