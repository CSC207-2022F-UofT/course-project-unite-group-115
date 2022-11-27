package random_grouper_create.application_business_rules;

import java.util.List;

public class RanGroupCreateRequestModel {
    private String groupName;
    private List<String> interests;
    private String groupCreatorName;

    /**
     * Creates a data structure that contains the information required to create a new group.
     * @param groupName name of the new group
     * @param interests List of interests that the group possesses
     * @param groupCreatorName name of the User that created the group
     */
    public RanGroupCreateRequestModel(String groupName, List<String> interests, String groupCreatorName){
        this.groupName = groupName;
        this.interests = interests;
        this.groupCreatorName = groupCreatorName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getGroupCreator() {
        return groupCreatorName;
    }

}
