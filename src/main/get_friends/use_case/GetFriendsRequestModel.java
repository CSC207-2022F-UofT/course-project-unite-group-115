package get_friends.use_case;
import get_friends.entities.Profile;

public class GetFriendsRequestModel {
    private Profile userProfile;

    public GetFriendsRequestModel(Profile userProfile) {
        this.userProfile = userProfile;
    }

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }

    public Profile getUserProfile() {
        return this.userProfile;
    }

}
