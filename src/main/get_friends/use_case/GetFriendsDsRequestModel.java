package get_friends.use_case;
import get_friends.entities.Profile;

public class GetFriendsDsRequestModel {
    private Profile userProfile;

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
