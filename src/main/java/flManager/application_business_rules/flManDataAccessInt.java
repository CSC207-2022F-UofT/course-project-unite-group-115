package flManager.application_business_rules;

import database_classes.flManRepoRequestModel;

import java.util.List;

public interface flManDataAccessInt {
    void addFriend(flManRepoRequestModel requestModel);

    List<String> getFriends(String owner);

    void addFri(String owner, String userName);
}
