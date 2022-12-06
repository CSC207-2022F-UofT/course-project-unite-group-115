package get_friends.get_friends.use_case;

public interface GetFriendsOutputBoundary {
    /**
     * Formats the information in GetFriendsDsResponse model, in other words the list of friends
     * that is being returned.
     * @param friends List of friends being returned by the interactor
     * @return Formatted list of friends in type of GetFriendsDsResponseModel
     */
    GetFriendsDsResponseModel prepareFriendsList(GetFriendsDsResponseModel friends);
}
