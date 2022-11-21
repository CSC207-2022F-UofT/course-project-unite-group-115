package get_friends.entities;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String name;
    private List<String> interests;
    private List<String> groups;

    public User(String name, List<String> interests){
        this.name = name;
        this.interests = interests;
        this.groups = new ArrayList<>();
    }

    public User(String name){
        this.name = name;
        List<String> interests = new ArrayList<>();
        interests.add("blue");
        interests.add("cookies");
        interests.add("baking");
        this.interests = interests;
        this.groups = new ArrayList<>();
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

    public List<String> getGroups() {
        return groups;
    }

    public void addGroup(String groupID) {
        this.groups.add(groupID);
    }

    public void removeGroup(String groupID) {
        this.groups.remove(groupID);
    }
}