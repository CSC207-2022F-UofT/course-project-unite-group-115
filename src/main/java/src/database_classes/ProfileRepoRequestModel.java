package database_classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ProfileRepoRequestModel {
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

    private final LocalDateTime creationTime;

    public ProfileRepoRequestModel(String userName,
                                   String profileName,
                                   LocalDate dob,
                                   String description,
                                   List<String> socialLinks,
                                   List<String> sensitiveWords,
                                   List<String> interests,
                                   List<String> groups,
                                   List<String> friends,
                                   List<String> blockedUsers,
                                   LocalDateTime creationTime) {

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

        this.creationTime = creationTime;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getProfileName() {
        return this.profileName;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public String getDescription() {
        return this.description;
    }

    public List<String> getSocialLinks() {
        return this.socialLinks;
    }

    public List<String> getSensitiveWords() {
        return this.sensitiveWords;
    }

    public List<String> getInterests() {
        return this.interests;
    }

    public List<String> getGroups() {
        return this.groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<String> getFriends() {
        return this.friends;
    }

    public List<String> getBlockedUsers() {
        return this.blockedUsers;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}