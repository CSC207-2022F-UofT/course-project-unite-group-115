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
    public ReqRanGroupResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    /**
     * Returns the group ID of the group that the user was added to.
     */
    public String getAddedToGroupID() {
        return addedToGroupID;
    }

    /**
     * Returns the group name of the group that the user was added to.
     */
    public String getAddedToGroupName() {
        return addedToGroupName;
    }

    /**
     * Returns the success message that was created when the user was added to a random group.
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * Changes the success message that was created when the user was added to a random group.
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailMessage() {
        return failMessage;
    }
}
