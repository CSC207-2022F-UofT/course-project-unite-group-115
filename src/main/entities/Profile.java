import java.time.LocalDate;
import java.util.ArrayList;

public class Profile{
    private String profileName;
    private LocalDate dob;
    private String description;
    private ArrayList<String> socialLinks;
    private ArrayList<String> sensitiveWords;
    private ArrayList<String> interests;
    private ArrayList<Integer> groupsIds;
    private ArrayList<User> friends;
    private ArrayList<User> blockedUsers;

    public String getProfileName() {
        return this.profileName;
    }
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description= description;
    }


}
