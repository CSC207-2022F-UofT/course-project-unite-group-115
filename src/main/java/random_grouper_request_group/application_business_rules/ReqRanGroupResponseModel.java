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

    public ReqRanGroupResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    public String getAddedToGroupID() {
        return addedToGroupID;
    }

    public String getAddedToGroupName() {
        return addedToGroupName;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailMessage() {
        return failMessage;
    }
}
