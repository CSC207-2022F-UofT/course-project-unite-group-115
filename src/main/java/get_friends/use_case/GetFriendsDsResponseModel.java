package get_friends.use_case;
import java.util.List;
import java.util.ArrayList;

public class GetFriendsDsResponseModel {
    private List<String> friendList;

    public GetFriendsDsResponseModel(List<String> friendList) {
        this.friendList = new ArrayList<>(friendList);
    }

    public void setFriendList(List<String> friendList) {
        this.friendList = friendList;
    }

    public List<String> getFriendList() {
        return friendList;
    }

}
