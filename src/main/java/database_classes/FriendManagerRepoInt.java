package database_classes;

import use_cases.friend_manager.application_business_rules.flManDataAccessInt;

public interface FriendManagerRepoInt extends flManDataAccessInt {
    void addFriend(FriendManagerRepoRequestModel requestModel);

    void delFriend(String userName);

    void addFri(String owner, String userName);

    void delFri(String owner, String userName);
}
