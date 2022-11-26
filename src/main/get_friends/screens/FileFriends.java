package get_friends.screens;

import get_friends.use_case.GetFriendsDsGateway;
import get_friends.use_case.GetFriendsRequestModel;
import java.io.File;


public class FileFriends implements GetFriendsDsGateway {

    private final File csvFile;


    @Override
    public boolean isAFriend(String username) {
        return false;
    }

    @Override
    public void save(GetFriendsRequestModel requestModel) {

    }
}
