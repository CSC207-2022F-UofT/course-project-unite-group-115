package get_friends.get_friends.use_case;

public class GetFriendsInteractor implements GetFriendsInputBoundary{
    final GetFriendsOutputBoundary friendsOutputBoundary;

    public GetFriendsInteractor(GetFriendsOutputBoundary friendsOutputBoundary) {
        this.friendsOutputBoundary = friendsOutputBoundary;
    }

    /**
     * Uses requestModel to get the list of friends of the user and turns it into the response model
     * @param requestModel The profile of the user being passed into the interactor
     * @return The formatted list of friends of the user
     */
    @Override
    public GetFriendsDsResponseModel getFriendsList(GetFriendsDsRequestModel requestModel) {
        GetFriendsDsResponseModel friendList = new GetFriendsDsResponseModel(requestModel.getUserProfile().getFriends());
        return(friendsOutputBoundary.prepareFriendsList(friendList));
    }
}
