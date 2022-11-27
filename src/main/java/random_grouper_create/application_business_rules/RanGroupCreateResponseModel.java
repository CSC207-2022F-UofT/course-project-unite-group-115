package random_grouper_create.application_business_rules;

public class RanGroupCreateResponseModel {
    private boolean success;

    // ToDo: change to GroupID?
    private String createdGroupName;
    private String creationTime;
    private String failMessage;

    /**
     * Creates a data structure that contains information about a successful group creation
     * @param createdGroupName name of the created group
     * @param creationTime time the group was created
     */
    public RanGroupCreateResponseModel(String createdGroupName, String creationTime){
        this.success = true;
        this.createdGroupName = createdGroupName;
        this.creationTime = creationTime;
    }

    /**
     * Creates a data structure that contains information about a failure to create a group
     * @param failMessage a String containing a message that explains why the error occurred
     */
    // ToDo: Remove if not used
    public RanGroupCreateResponseModel(String failMessage){
        this.success = false;
        this.failMessage = failMessage;
    }

    // ToDo: Remove if not used
    public boolean isSuccess() {
        return success;
    }

    // ToDo: Remove if not used
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // ToDo: Remove if not used
    public String getCreatedGroupName() {
        return createdGroupName;
    }

    // ToDo: Remove if not used
    public void setCreatedGroup(String createdGroupName) {
        this.createdGroupName = createdGroupName;
    }

    /**
     * Returns the time that the new group was reportedly created.
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Changes the time that the new group was reportedly created.
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    // ToDo: Remove if not used
    public String getFailMessage() {
        return failMessage;
    }

    // ToDo: Remove if not used
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }
}
