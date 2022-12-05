package get_friends.interface_adapters;

import get_friends.use_case.GetFriendsDsResponseModel;
import get_friends.use_case.GetFriendsOutputBoundary;

public class GetFriendsPresenter implements GetFriendsOutputBoundary {

    @Override
    public GetFriendsDsResponseModel prepareFriendsList(GetFriendsDsResponseModel friends) {
        return friends;
    }
}
