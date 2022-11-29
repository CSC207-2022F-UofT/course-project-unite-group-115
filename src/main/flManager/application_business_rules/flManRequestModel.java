package flManager.application_business_rules;

import java.util.List;

public class flManRequestModel {
    private String owner;
    private List<String> friends;
    private int value;

    public flManRequestModel(String owner, List<String> friends){
        this.owner = owner;
        this.friends = friends;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addFri(String user){
        this.friends.add(user);
    }

    public void delFri(String user){
        this.friends.remove(user);
    }

    /*
    public static String viewFri(String owner, List<String> friends){
        flManRequestModel fl = new flManRequestModel(owner, friends);
        return fl.friends.toString();
    }

     */

    public void implement(String owner, int value, String user, List<String> friends){
        flManRequestModel fl = new flManRequestModel(owner, friends);
        if (value == 0){
            fl.delFri(user);
        } else if (value == 1) {
            fl.addFri(user);
        }
    }
}
