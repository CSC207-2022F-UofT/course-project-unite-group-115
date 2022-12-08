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

    public void addSocialLinkToProfile(String userName, String socialLink) {
        List<String> socialLinks = new ArrayList<>(accounts.get(userName).getSocialLinks());
        socialLinks.add(socialLink);
        accounts.get(userName).setSocialLinks(socialLinks);
    }

    public void removeSocialLinkFromProfile(String userName, String socialLink) {
        List<String> socialLinks = new ArrayList<>(accounts.get(userName).getSocialLinks());
        socialLinks.remove(socialLink);
        accounts.get(userName).setSocialLinks(socialLinks);

    }

    public void addSensitiveWordsToProfile(String userName, String sensitiveWord) {
        List<String> sensitiveWords = new ArrayList<>(accounts.get(userName).getSensitiveWords());
        sensitiveWords.add(sensitiveWord);
        accounts.get(userName).setSensitiveWords(sensitiveWords);

    }

    public void removeSensitiveWordsFromProfile(String userName, String sensitiveWord) {
        List<String> sensitiveWords = new ArrayList<>(accounts.get(userName).getSensitiveWords());
        sensitiveWords.remove(sensitiveWord);
        accounts.get(userName).setSensitiveWords(sensitiveWords);

    }

    public void addInterestToProfile(String userName, String interest) {
        List<String> interests = new ArrayList<>(accounts.get(userName).getInterests());
        interests.add(interest);
        accounts.get(userName).setInterests(interests);

    }

    public void removeInterestFromProfile(String userName, String interest) {
        List<String> interests = new ArrayList<>(accounts.get(userName).getInterests());
        interests.remove(interest);
        accounts.get(userName).setInterests(interests);

    }

    public void addGroupToProfile(String userName, String groupId) {
        List<String> groups = new ArrayList<>(accounts.get(userName).getGroups());
        groups.add(groupId);
        accounts.get(userName).setGroups(groups);

    }

    public void removeGroupFromProfile(String userName, String groupId) {
        List<String> groups = new ArrayList<>(accounts.get(userName).getGroups());
        groups.remove(groupId);
        accounts.get(userName).setGroups(groups);

    }

    public void addFriendsToProfile(String userName, String friend) {
        List<String> friends = new ArrayList<>(accounts.get(userName).getFriends());
        friends.add(friend);
        accounts.get(userName).setFriends(friends);

    }

    public void removeFriendFromProfile(String userName, String friend) {
        List<String> friends = new ArrayList<>(accounts.get(userName).getFriends());
        friends.remove(friend);
        accounts.get(userName).setFriends(friends);

    }

    public void addBlockedUserToProfile(String userName, String blockedUser) {
        String blockList = accounts.get(userName).getBlockedUsers();
        blockList = blockList.replace("[","").replace("]","");
        String newBlocked ="[";
        if(blockList ==""){
            blockList = newBlocked +blockedUser+"]";
        }else{
            blockList = newBlocked +blockList +";"+blockedUser+"]";
        }
        accounts.get(userName).setBlockedUsers(blockList);


    }

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


    @Override
    public List<String> getSensitiveWords(String userName) {

        return accounts.get(userName).getSensitiveWords();
    }

    @Override
    public List<String> getInterests(String userName) {
        return accounts.get(userName).getInterests();
    }

    @Override
    public List<String> getGroups(String userName) {
        return accounts.get(userName).getGroups();
    }

    @Override
    public String getBlockedUser(String userName) {
        return accounts.get(userName).getBlockedUsers();
    }
}
