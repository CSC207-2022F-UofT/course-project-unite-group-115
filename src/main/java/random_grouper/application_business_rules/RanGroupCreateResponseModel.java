package random_grouper.application_business_rules;

import entities.Group;

public class RanGroupCreateResponseModel {
    private boolean success;
    private String createdGroupName;
    private String creationTime;
    private String failMessage;

    public RanGroupCreateResponseModel(String createdGroupName, String creationTime){
        this.success = true;
        this.createdGroupName = createdGroupName;
        this.creationTime = creationTime;
    }

    public RanGroupCreateResponseModel(String failMessage){
        this.success = false;
        this.failMessage = failMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCreatedGroupName() {
        return createdGroupName;
    }

    public void setCreatedGroup(String createdGroupName) {
        this.createdGroupName = createdGroupName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }
}
