package database_classes;

import java.util.List;

public interface ProfileRepoInt {
    boolean existsByName(String identifier);

    void save(ProfileRepoRequestModel requestModel);

    void addSocialLinkToProfile(String userName, String socialLink);
    void removeSocialLinkFromProfile(String userName, String socialLink);
    void addSensitiveWordsToProfile(String userName, String sensitiveWord);
    void removeSensitiveWordsFromProfile(String userName, String sensitiveWord);
    void addInterestToProfile(String userName, String interest);
    void removeInterestFromProfile(String userName, String interest);
    void addGroupToProfile(String userName, String groupId);
    void removeGroupFromProfile(String userName, String groupId);
    void addFriendToProfile(String userName, String friend);
    void removeFriendFromProfile(String userName, String friend);
    void addBlockedUserToProfile(String userName, String blockedUser);
    //
//    void removeBlockedUserFromProfile(String userName, String blockedUser);

    List<String> getInterests(String userName);

    List<String> getGroups(String userName);

    List<String> getFriends(String userName);
}