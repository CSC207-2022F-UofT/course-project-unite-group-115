package database_classes;

import flManager.application_business_rules.flManDataAccessInt;

public interface flManRepoInt extends flManDataAccessInt {
    void addFriend(flManRepoRequestModel requestModel);

    void delFriend(String userName);

    void addFri(String owner, String userName);

    void delFri(String owner, String userName);
}
