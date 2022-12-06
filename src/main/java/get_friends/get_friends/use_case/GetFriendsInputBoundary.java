package get_friends.get_friends.use_case;


public interface GetFriendsInputBoundary {
    /**
     * Finds the list of friends using the given profile and returns it
     * @param requestModel The name of the user
     * @return The list of friends
     */
    GetFriendsDsResponseModel getFriendsList(GetFriendsDsRequestModel requestModel);
}
