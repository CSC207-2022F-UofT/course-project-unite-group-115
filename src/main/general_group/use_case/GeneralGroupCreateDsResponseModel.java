package general_group.use_case;

public class GeneralGroupCreateDsResponseModel {
    private String creationTime;
    private final String groupID;
    private String groupName;

    public GeneralGroupCreateDsResponseModel(String creationTime, String groupID, String groupName) {
        this.creationTime = creationTime;
        this.groupID = groupID;
        this.groupName = groupName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupID() {
        return groupID;
    }


}
