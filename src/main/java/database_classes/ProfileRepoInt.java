package database_classes;

import java.util.List;

public interface ProfileRepoInt {
    boolean existsByName(String identifier);

    void save(ProfileRepoRequestModel requestModel);

    void addFriendsToProfile(String owner, String friend);

    List<String> getFriends(String owner);

    void deleteFriendsToProfile(String owner, String friend);

    List<String> ViewFriendsToProfile(String username);
}
