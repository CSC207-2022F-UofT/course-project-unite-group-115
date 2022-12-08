package database_classes;

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
    public void addFriendsToProfile(String owner, String friend) {
        List<String> friends = new ArrayList<>(accounts.get(owner).getFriends());
        friends.add(friend);
        accounts.get(owner).setFriends(friends);
    }

    @Override
    public List<String> getFriends(String owner) {
        return accounts.get(owner).getFriends();
    }

    @Override
    public void deleteFriendsToProfile(String owner, String friend) {
        List<String> friends = new ArrayList<>(accounts.get(owner).getFriends());
        friends.remove(friend);
        accounts.get(owner).setFriends(friends);
    }

    @Override
    public List<String> ViewFriendsToProfile(String owner) {
        List<String> friends = new ArrayList<>(accounts.get(owner).getFriends());
        accounts.get(owner).setFriends(friends);
        return friends;
    }
}
