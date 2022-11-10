package random_grouper_request_group.application_business_rules;

import java.util.List;

public class ReqRanGroupRequestModel {
    private List<String> userInterests;

    private List<String> userGroups;

    private String userName;


    public ReqRanGroupRequestModel(String userName, List<String> userInterests, List<String> userGroupsIDs) {
        this.userName = userName;
        this.userInterests = userInterests;
        this.userGroups = userGroupsIDs;
    }

    public List<String> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<String> userGroups) {
        this.userGroups = userGroups;
    }

    public void addToUserGroups(String newGroup) {
        this.userGroups.add(newGroup);
    }

    public List<String> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(List<String> userInterests) {
        this.userInterests = userInterests;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
