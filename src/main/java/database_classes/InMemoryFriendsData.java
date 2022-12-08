package database_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFriendsData implements FriendManagerRepoInt {
    final private Map<String, FriendManagerRepoRequestModel> friends = new HashMap<>();

    /**
     * Add friends from requestModel into the flManDatabase file.
     *
     * @param requestModel information about friend list to save
     */
    @Override
    public void addFriend(FriendManagerRepoRequestModel requestModel) {
        friends.put(requestModel.getOwner(), requestModel);
    }

    /**
     * Delete the friend with username, from the flManDatabase file.
     *
     * @param userName this friend's username
     */
    @Override
    public void delFriend(String userName) {
        friends.remove(userName);
    }

    /**
     * Update the flManDatabase by adding friend with username, <userName>,
     * to the friend list with the owner's username, <owner>.
     *
     *
     * @param owner  owner's username
     * @param userName name of an existing User
     */
    @Override
    public void addFri(String owner, String userName) {
        List<String> fl = new ArrayList<>(friends.get(owner).getFriends());
        fl.add(userName);
        friends.get(owner).setFriends(fl);
    }

    /**
     * Update the flManDatabase by deleting User with name, <userName>,
     * from the friend list with the owner's username, <owner>.
     *
     * @param owner  owner's username
     * @param userName name of an existing User
     */
    @Override
    public void delFri(String owner, String userName) {
        List<String> fl = new ArrayList<>(friends.get(owner).getFriends());
        fl.remove(userName);
        friends.get(owner).setFriends(fl);
    }


    /**
     * Get a list of friends matching the required owner's username.
     *
     * @param owner  owner's username
     * @return Returns a List of Strings where each String represents of a friend of the owner.
     */
    @Override
    public List<String> getFriends(String owner) {
        List<String> fl = new ArrayList<>();
        for (FriendManagerRepoRequestModel requestModel : friends.values()) {
            fl.add(requestModel.getOwner());
        }
        return fl;
    }
}
