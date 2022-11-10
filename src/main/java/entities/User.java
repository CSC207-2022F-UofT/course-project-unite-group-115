package entities;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String name;
    private List<String> interests;

    public User(String name, List<String> interests){
        this.name = name;
        this.interests = interests;
    }

    public User(String name){
        this.name = name;
        List<String> interests = new ArrayList<>();
        interests.add("blue");
        interests.add("cookies");
        interests.add("baking");
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