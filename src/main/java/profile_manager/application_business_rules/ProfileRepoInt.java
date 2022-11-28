package profile_manager.application_business_rules;

public interface ProfileRepoInt {
    boolean existsByName(String identifier);

    void save(ProfileRepoRequestModel requestModel);
    void addGroupToProfile(String userName, String groupId);
    void removeGroupFromProfile(String userName, String groupId);
    void addInterestToProfile(String userName, String interest);
    void removeInterestFromProfile(String userName, String interest);
    void addFriendToProfile(String userName, String friend);
    void removeFriendFromProfile(String userName, String friend);
    void addBlockedUserToProfile(String userName, String blockedUser);
    void removeBlockedUserFromProfile(String userName, String blockedUser);

}
