package Reporter_Database;

import java.util.List;

public interface ProfileRepoInt {
    boolean existsByName(String identifier);

    void save(ProfileRepoRequestModel requestModel);

    List<String> getSensitiveWords(String username);

    void addBlockedUserToProfile(String userName, String blockedUser);

    String getBlockedUser(String username);
    //void removeBlockedUserFromProfile(String userName, String blockedUser);


}