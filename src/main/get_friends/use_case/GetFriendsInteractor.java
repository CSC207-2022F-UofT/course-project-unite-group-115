package get_friends.use_case;

public class GetFriendsInteractor implements GetFriendsInputBoundary{

    public GetFriendsInteractor() {
        //Empty
    }

    @Override
    public GetFriendsDsResponseModel getFriendsList(GetFriendsRequestModel requestModel) {
        return(new GetFriendsDsResponseModel(requestModel.getUserProfile().getFriends()));
    }
}
