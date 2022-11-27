package databases;

import java.util.List;

public interface ProfileRepoInt {
    boolean existsByName(String identifier);

    void save(ProfileRepoRequestModel requestModel);

    void addGroupToProfile(String userName, String groupId);

    List<String> getInterests(String userName);

    List<String> getGroups(String userName);
}