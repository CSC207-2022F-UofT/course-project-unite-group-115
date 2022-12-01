package database_classes;

import general_group.entities.User;

import java.util.List;

public class GroupRepoDsRequestModel {

    private String name;
    private List<String> interests;
    private final String ID;
    private List<String> members;
    private final boolean random;

    public GroupRepoDsRequestModel(String name, List<String> interests, String ID, List<String> members,
                                   boolean random) {
        this.name = name;
        this.interests = interests;
        this.ID = ID;
        this.members = members;
        this.random = random;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getInterests() {
        return this.interests;
    }

    public String getID() {
        return this.ID;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<String> getMembers() {
        return members;
    }

    public boolean isRandom() {
        return this.random;
    }
}
