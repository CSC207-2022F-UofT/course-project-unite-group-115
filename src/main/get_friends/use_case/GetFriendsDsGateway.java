package get_friends.use_case;

public interface GetFriendsDsGateway {

    boolean isAFriend(String username);

    void save(GetFriendsRequestModel requestModel);
}
