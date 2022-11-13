package entities;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profile{
    private String profileName;
    private LocalDate dob;
    private String description;
    private ArrayList<String> socialLinks;
    private ArrayList<String> sensitiveWords;
    private ArrayList<String> interests;
    private ArrayList<String> groups;
    private ArrayList<User> friends;
    private ArrayList<User> blockedUsers;

    public String getProfileName() {
        return this.profileName;
    }
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LocalDate getDob() {
        return this.dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description= description;
    }

    public ArrayList<String> getSocialLinks() {
        return this.socialLinks;
    }
    public void setSocialLinks(ArrayList<String> socialLinks) {
        this.socialLinks= socialLinks;
    }

    public ArrayList<String> getSensitiveWords() {
        return this.sensitiveWords;
    }
    public void setSensitiveWords(ArrayList<String> sensitiveWords) {
        this.sensitiveWords=sensitiveWords;
    }

    public ArrayList<String> getInterests() {
        return this.interests;
    }
    public void setInterests(ArrayList<String> interests) {
        this.interests= interests;
    }

    public ArrayList<String> getGroups() {
        return this.groups;
    }
    public void setGroups(ArrayList<String> groups) {
        this.groups= groups;
    }
    public void addGroup(String group) {
        this.groups.add(group);
    }
    public void removeGroup(String group) {
        this.groups.remove(group);
    }

    public ArrayList<User> setFriends() {
        return this.friends;
    }
    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
    public void addFriend(User friend) {
        this.friends.add(friend);
    }
    public void removeFriend(User friend) {
        this.friends.remove(friend);
    }

    public ArrayList<User> getBlockedUsers() {
        return this.blockedUsers;
    }
    public void setBlockedUsers(ArrayList<User> blockedUser) {
        this.blockedUsers = blockedUser;
    }
    public void addBlockedUser(User blockedUser) {
        this.blockedUsers.add(blockedUser);
    }
    public void removeBlockedUser(User blockedUser) {
        this.blockedUsers.remove(blockedUser);
    }





}
