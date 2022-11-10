package random_grouper_request_group.application_business_rules;

public class ReqRanGroupResponseModel {
    private String addedToGroupID;
    private String addedToGroupName;
    private String successMessage;
    private String failMessage;

    public ReqRanGroupResponseModel(String addedToGroupID, String addedToGroupName) {
        this.addedToGroupID = addedToGroupID;
        this.addedToGroupName = addedToGroupName;
        this.successMessage = "Success";
    }

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
