package general_group.use_case;

import java.util.List;
public class GeneralGroupCreateDsRequestModel {
    private String groupName;
    private List<String> friendsToAdd;

    public GeneralGroupCreateDsRequestModel(String groupName, List<String> friendsToAdd) {
        this.groupName = groupName;
        this.friendsToAdd = friendsToAdd;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<String> getFriendsToAdd() {
        return friendsToAdd;
    }

    public void setFriendsToAdd(List<String> friendsToAdd) {
        this.friendsToAdd = friendsToAdd;
    }
}
