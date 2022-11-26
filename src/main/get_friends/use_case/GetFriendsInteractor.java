package get_friends.use_case;

public class GetFriendsInteractor implements GetFriendsInputBoundary{

    public GetFriendsInteractor() {
        //Empty
    }

    @Override
    public GetFriendsDsResponseModel getFriendsList(GetFriendsDsRequestModel requestModel) {
        return(new GetFriendsDsResponseModel(requestModel.getUserProfile().getFriends()));
    }
}
