package Entities;

public class FriendListFactory {
    public static FriendList create(String owner) {
        return new FriendList(owner);
    }
}
