package entities;

import java.util.List;

public class FriendListFactory {
    public static FriendList create(String owner, List<String> friends) {
        return new FriendList(owner, friends);
    }
}
