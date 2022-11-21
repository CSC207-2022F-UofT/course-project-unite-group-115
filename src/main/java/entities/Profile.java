package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import profile_manager.frameworks_and_drivers.LoginScreen;
public class Profile{
    private final String userName;
    private String profileName;
    private LocalDate dob;
    private String description;
    private List<String> socialLinks;
    private List<String> sensitiveWords;
    private List<String> interests;
    private List<String> groups;
    private List<String> friends;
    private List<String> blockedUsers;

    public Profile(String userName,
                   String profileName,
                   LocalDate dob,
                   String description,
                   List<String> socialLinks,
                   List<String> sensitiveWords,
                   List<String> interests,
                   List<String> groups,
                   List<String> friends,
                   List<String> blockedUsers) {

        this.userName = userName;
        this.profileName = profileName;
        this.dob = dob;
        this.description = description;
        this.socialLinks = socialLinks;
        this.sensitiveWords = sensitiveWords;
        this.interests = interests;
        this.groups = groups;
        this.friends = friends;
        this.blockedUsers = blockedUsers;
    }

    public String getUserName() {
        return this.userName;
    }

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
        this.description = description;
    }

    public List<String> getSocialLinks() {
        return this.socialLinks;
    }
    public void setSocialLinks(ArrayList<String> socialLinks) {
        this.socialLinks = socialLinks;
    }
    public void addSocialLinks(String socialLink) {
        this.socialLinks.add(socialLink);
    }
    public void removeSocialLinks(String socialLink) {
        this.socialLinks.remove(socialLink);
    }

    public List<String> getSensitiveWords() {
        return this.sensitiveWords;
    }
    public void setSensitiveWords(ArrayList<String> sensitiveWords) {
        this.sensitiveWords = sensitiveWords;
    }
    public void addSensitiveWords(String sensitiveWord) {
        this.sensitiveWords.add(sensitiveWord);
    }
    public void removeSensitiveWords(String sensitiveWord) {
        this.sensitiveWords.remove(sensitiveWord);
    }

    public List<String> getInterests() {
        return this.interests;
    }
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }
    public void addInterests(String interest) {
        this.interests.add(interest);
    }
    public void removeInterests(String interest) {
        this.interests.remove(interest);
    }

    public List<String> getGroups() {
        return this.groups;
    }
    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }
    public void addGroup(String group) {
        this.groups.add(group);
    }
    public void removeGroup(String group) {
        this.groups.remove(group);
    }

    public List<String> getFriends() {
        return this.friends;
    }
    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }
    public void addFriend(String friend) {
        this.friends.add(friend);
    }
    public void removeFriend(String friend) {
        this.friends.remove(friend);
    }

    public List<String> getBlockedUsers() {
        return this.blockedUsers;
    }
    public void setBlockedUsers(ArrayList<String> blockedUser) {
        this.blockedUsers = blockedUser;
    }
    public void addBlockedUser(String blockedUser) {
        this.blockedUsers.add(blockedUser);
    }
    public void removeBlockedUser(String blockedUser) {
        this.blockedUsers.remove(blockedUser);
    }

}