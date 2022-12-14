package use_cases.friend_manager.application_business_rules;

import java.util.List;

public class flManResponseModel {
    private String owner;
    private List<String> friends;
    private String successMessage;
    private String failMessage;
    public flManResponseModel(String owner, List<String> friends) {
        this.owner = owner;
        this.friends = friends;
        this.successMessage = "Success";
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public flManResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
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
