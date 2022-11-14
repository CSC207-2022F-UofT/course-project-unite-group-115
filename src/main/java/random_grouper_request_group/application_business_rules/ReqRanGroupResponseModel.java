package random_grouper_request_group.application_business_rules;

public class ReqRanGroupResponseModel {
    private String addedToGroupID;
    private String addedToGroupName;
    private String successMessage;
    private String failMessage;

    /**
     * Creates a data structure that contains information about the group the User was successfully added to
     * @param addedToGroupID the ID of the group the User was added to
     * @param addedToGroupName the name of the group the User was added to
     */
    public ReqRanGroupResponseModel(String addedToGroupID, String addedToGroupName) {
        this.addedToGroupID = addedToGroupID;
        this.addedToGroupName = addedToGroupName;
        this.successMessage = "Success";
    }

    /**
     * Creates a data structure that contains information about a failure to add the User to a random group
     * @param errorMessage a String containing a message that explains why the error occurred
     */
    // ToDo: Remove if not used
    public ReqRanGroupResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    public String getAddedToGroupID() {
        return addedToGroupID;
    }

    // ToDo: Remove if not used
    public void setAddedToGroupID(String addedToGroupID) {
        this.addedToGroupID = addedToGroupID;
    }

    public String getAddedToGroupName() {
        return addedToGroupName;
    }

    // ToDo: Remove if not used
    public void setAddedToGroupName(String addedToGroupName) {
        this.addedToGroupName = addedToGroupName;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
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
