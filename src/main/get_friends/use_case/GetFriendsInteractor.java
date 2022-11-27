package get_friends.use_case;

import java.util.List;

public class GetFriendsInteractor implements GetFriendsInputBoundary{
    final GetFriendsOutputBoundary friendsOutputBoundary;

    public GetFriendsInteractor(GetFriendsOutputBoundary friendsOutputBoundary) {
        this.friendsOutputBoundary = friendsOutputBoundary;
    }

    @Override
    public GetFriendsDsResponseModel getFriendsList(GetFriendsDsRequestModel requestModel) {
        GetFriendsDsResponseModel friendList = new GetFriendsDsResponseModel(requestModel.getUserProfile().getFriends());
        return(friendsOutputBoundary.prepareFriendsList(friendList));
    }
}
