package get_friends.get_friends.use_case;

import database_classes.ProfileRepoInt;

public class GetFriendsInteractor implements GetFriendsInputBoundary{
    final GetFriendsOutputBoundary friendsOutputBoundary;
    final ProfileRepoInt profileDatabase;

    public GetFriendsInteractor(GetFriendsOutputBoundary friendsOutputBoundary, ProfileRepoInt profileDatabase) {
        this.friendsOutputBoundary = friendsOutputBoundary;
        this.profileDatabase = profileDatabase;
    }

    /**
     * Uses requestModel to get the list of friends of the user and turns it into the response model
     * @param requestModel The name of the user being passed into the interactor
     * @return The formatted list of friends of the user
     */
    @Override
    public GetFriendsDsResponseModel getFriendsList(GetFriendsDsRequestModel requestModel) {
        String username = requestModel.getUsername();
        GetFriendsDsResponseModel friendList = new GetFriendsDsResponseModel(profileDatabase.getFriends(username));
        return friendList;
    }
}
