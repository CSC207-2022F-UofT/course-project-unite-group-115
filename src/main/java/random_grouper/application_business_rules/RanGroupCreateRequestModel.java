package random_grouper.application_business_rules;

import java.util.List;

public class RanGroupCreateRequestModel {
    private String groupName;
    private List<String> interests;
    private String groupCreatorName;

    public RanGroupCreateRequestModel(String groupName, List<String> interests, String groupCreatorName){
        this.groupName = groupName;
        this.interests = interests;
        this.groupCreatorName = groupCreatorName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getGroupCreator() {
        return groupCreatorName;
    }

    public void setGroupCreator(String groupCreator) {
        this.groupCreatorName = groupCreator;
    }
}
