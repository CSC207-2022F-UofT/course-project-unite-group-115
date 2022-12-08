package use_cases.get_groups.application_business_rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetGroupsResponseModel {
    private Map<String, String> groups;
    private String failMessage;
    private List<String> groupNames;

    public GetGroupsResponseModel(Map<String, String> groups){

        this.groups = groups;
        this.groupNames = new ArrayList<>(groups.keySet());
        }

    public GetGroupsResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    /**
     * Return a map containing the groups user is a part of. The key is the name of the group, and the value is the
     * id of the group.
     */
    public Map<String, String> getGroups() {
        return groups;
    }

    /**
     * Return a list of the names of all the groups the user is a part of.
     */
    public List<String> getGroupNames() {
        return groupNames;
    }

    /**
     * Change the stored group names to <groupNames>.
     */
    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    /**
     * Returns a message explaining why the use case failed to get the user's groups.
     */
    public String getFailMessage() {
        return failMessage;
    }
}
