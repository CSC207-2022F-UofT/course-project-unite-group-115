package general_group.use_case;

public class GeneralGroupCreateDsResponseModel {
    private String creationTime;
    private final String groupID;
    private String groupName;
    private boolean success;

    public GeneralGroupCreateDsResponseModel(String creationTime, String groupID, String groupName) {
        this.success = true;
        this.creationTime = creationTime;
        this.groupID = groupID;
        this.groupName = groupName;
    }

    public boolean isSuccess() {
        return success;
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

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupID;
    }


}
