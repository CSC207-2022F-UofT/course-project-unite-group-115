package entities;

import java.util.List;

public class User{
    private String name;
    private List<String> interests;

    public User(String name, List<String> interests){
        this.name = name;
        this.interests = interests;
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
}