package friend_manager.application_business_rules;

import database_classes.FriendManagerRepoRequestModel;

import java.util.List;

public interface flManDataAccessInt {
    void addFriend(FriendManagerRepoRequestModel requestModel);

    List<String> getFriends(String owner);

    void addFri(String owner, String userName);
}
