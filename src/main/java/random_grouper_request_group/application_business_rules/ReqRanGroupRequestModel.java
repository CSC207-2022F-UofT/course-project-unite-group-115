package random_grouper_request_group.application_business_rules;

import java.util.List;

public class ReqRanGroupRequestModel {
    private List<String> userInterests;

    private List<String> userGroups;

    private String userName;

    /**
     * Creates a data structure that contains the information required for a User to be added to a random group.
     * @param userName the User's name
     * @param userInterests the User's interests
     * @param userGroupsIDs the IDs of the groups the User is already apart of
     */
    public ReqRanGroupRequestModel(String userName, List<String> userInterests, List<String> userGroupsIDs) {
        this.userName = userName;
        this.userInterests = userInterests;
        this.userGroups = userGroupsIDs;
    }

    public List<String> getUserGroups() {
        return userGroups;
    }

    // ToDo: Remove if not used
    public void setUserGroups(List<String> userGroups) {
        this.userGroups = userGroups;
    }

    public void addToUserGroups(String newGroup) {
        this.userGroups.add(newGroup);
    }

    public List<String> getUserInterests() {
        return userInterests;
    }

    // ToDo: Remove if not used
    public void setUserInterests(List<String> userInterests) {
        this.userInterests = userInterests;
    }

    /**
     * Returns the username of the user who requested to be added to a random group.
     */
    public String getUserName() {
        return userName;
    }

    // ToDo: Remove if not used
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
