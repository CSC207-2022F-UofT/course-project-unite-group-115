package random_grouper_create.application_business_rules;

public class RanGroupCreateResponseModel {
    private boolean success;
    private String createdGroupName;
    private String createdGroupID;
    private String creationTime;

    /**
     * Creates a data structure that contains information about a successful group creation
     * @param createdGroupName name of the created group
     * @param creationTime time the group was created
     */
    public RanGroupCreateResponseModel(String createdGroupName, String createdGroupID, String creationTime){
        this.success = true;
        this.createdGroupName = createdGroupName;
        this.createdGroupID = createdGroupID;
        this.creationTime = creationTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCreatedGroupName() {
        return createdGroupName;
    }

    public String getCreatedGroupID() {
        return createdGroupID;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
