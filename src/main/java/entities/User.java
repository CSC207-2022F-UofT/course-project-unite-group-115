package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private final String name;
    private String passWord;
    private Profile profile = null;


    public User(String userName, String passWord) {
        this.name = userName;
        this.passWord  = passWord;
        this.profile.setProfileName("");
        this.profile.setDob(LocalDate.of(2000, 1, 1));
        this.profile.setDescription("");
        this.profile.setSocialLinks(new ArrayList<String>());
        this.profile.setSensitiveWords(new ArrayList<String>());
        this.profile.setInterests(new ArrayList<String>());
        this.profile.setGroups(new ArrayList<String>());
        this.profile.setFriends(new ArrayList<User>());
        this.profile.setBlockedUsers(new ArrayList<User>());
    }

    public boolean passwordIsValid() {
        return true;
    };

    public String getName() {
        return this.name;
    };

    public String getPassword() {
        return this.passWord;
    };
}
