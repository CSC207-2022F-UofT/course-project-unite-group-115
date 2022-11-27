package databases;

import java.util.List;

public class GroupRepoRequestModel {
    private String name;
    private List<String> interests;
    private final String ID;
    private List<String> members;
    private final boolean random;

    /**
     * Create a data structure containing all the information about a group.
     *
     * @param name name of the group
     * @param id String representation of group's ID
     * @param interests List of the group's interests
     * @param members List of the group's members' names
     * @param isRandom whether the group is a random group (members are added by the software based on interests)
     */
    public GroupRepoRequestModel(String name, String id, List<String> interests, List<String> members,
                                 boolean isRandom) {
        this.name = name;
        this.interests = interests;
        this.ID = id;
        this.members = members;
        this.random = isRandom;
    }

    public String getName() {
        return name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getID() {
        return ID;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public boolean isRandom() {
        return random;
    }
}
