package databases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProfileData implements ProfileRepoInt{
    private final Map<String, ProfileRepoRequestModel> accounts = new HashMap<>();


    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(ProfileRepoRequestModel requestModel) {
        System.out.println("Save " + requestModel.getUserName());
        accounts.put(requestModel.getUserName(), requestModel);
    }

    @Override
    public void addGroupToProfile(String userName, String groupId) {
        List<String> groups = new ArrayList<>(accounts.get(userName).getGroups());
        groups.add(groupId);
        accounts.get(userName).setGroups(groups);
    }

    @Override
    public List<String> getInterests(String userName) {
        return accounts.get(userName).getInterests();
    }

    @Override
    public List<String> getGroups(String userName) {
        return accounts.get(userName).getGroups();
    }
}
