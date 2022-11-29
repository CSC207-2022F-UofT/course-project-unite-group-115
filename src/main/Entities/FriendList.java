package Entities;

import java.util.List;

public class FriendList {
    private String owner;
    //    private int totalFri = 0;
    private List<String> friends;

    public FriendList(String owner, List<String> friends){
        this.owner = owner;
        this.friends = friends;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

//    public int getTotalFri() {
//        return totalFri;
//    }
//
//    public void setTotalFri(int totalFri) {
//        this.totalFri = totalFri;
//    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void addFri(String user){
        this.friends.add(user);
    }

    public void delFri(String user){
        this.friends.remove(user);
    }

//    public static String viewFri(String owner, List<String> friends){
//        return friends.toString();
//    }

}
