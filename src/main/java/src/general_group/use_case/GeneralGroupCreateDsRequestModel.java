package general_group.use_case;

import general_group.entities.User;

import java.util.List;

public class GeneralGroupCreateDsRequestModel {
    private String groupName;
    private List<User> friendsToAdd;
    private String groupCreatorName;

    public GeneralGroupCreateDsRequestModel(String groupName, List<User> friendsToAdd, String groupCreatorName) {
        this.groupName = groupName;
        this.friendsToAdd = friendsToAdd;
        this.groupCreatorName = groupCreatorName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getFriendsToAdd() {
        return friendsToAdd;
    }

    public void setFriendsToAdd(List<User> friendsToAdd) {
        this.friendsToAdd = friendsToAdd;
    }

    public String getGroupCreatorName() {
        return groupCreatorName;
    }

    public void setGroupCreatorName(String groupCreatorName) {
        this.groupCreatorName = groupCreatorName;
    }

}